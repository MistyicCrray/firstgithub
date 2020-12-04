package com.springboot.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Michael
 * @blog http://sjsky.iteye.com
 */
public class IpPing {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // 读取txt文件中的IP列表
        IpPing pinger = new IpPing();
        List<String> iplist = new ArrayList<>();

        for (int i = 1; i < 255; i++) {
            String ip1 = "169.254.";
            ip1 += i;
            for (int j = 1; j < 255; j++) {
                iplist.add(ip1 + ("." + j));
            }
        }

        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(50, 60, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(50),
                new ThreadPoolExecutor.CallerRunsPolicy());
        long startTime = System.currentTimeMillis();
        final int maxCount = 4;
        for (final String ip : iplist) {
            executorPool.execute(new Runnable() {
                public void run() {
                    IpPing pinger = new IpPing();
                    Integer countSucce = pinger.doPingCmd(ip, maxCount);
                    if (null != countSucce) {
                        System.out.println("host:[ " + ip + " ] ping cout: "
                                + maxCount + " success: " + countSucce);

                    } else {
                        System.out
                                .println("host:[ " + ip + " ] ping cout null");
                    }
                }

            });
        }
        while (executorPool.getActiveCount() > 0) {
            Thread.sleep(100);
        }
        System.out.println("complete ping jobs count = " + iplist.size()
                + " , total used time(ms) = "
                + (System.currentTimeMillis() - startTime));
        executorPool.shutdown();
    }

    /**
     * @param destIp
     * @param maxCount
     * @return
     */
    public Integer doPingCmd(String destIp, int maxCount) {
        LineNumberReader input = null;
        try {
            String osName = System.getProperties().getProperty("os.name");
            String pingCmd = null;
            if (osName.startsWith("Windows")) {
                pingCmd = "cmd /c ping -n {0} {1}";
                pingCmd = MessageFormat.format(pingCmd, maxCount, destIp);
            } else if (osName.startsWith("Linux")) {
                pingCmd = "ping -c {0} {1}";
                pingCmd = MessageFormat.format(pingCmd, maxCount, destIp);
            } else {
                System.out.println("not support OS");
                return null;
            }
            Process process = Runtime.getRuntime().exec(pingCmd);
            InputStreamReader ir = new InputStreamReader(process
                    .getInputStream());
            input = new LineNumberReader(ir);
            String line;
            List<String> reponse = new ArrayList<String>();

            while ((line = input.readLine()) != null) {
                if (!"".equals(line)) {
                    reponse.add(line);
                    // System.out.println("====:" + line);
                }
            }
            if (osName.startsWith("Windows")) {
                return parseWindowsMsg(reponse, maxCount);
            } else if (osName.startsWith("Linux")) {
                return parseLinuxMsg(reponse, maxCount);
            }

        } catch (IOException e) {
            System.out.println("IOException   " + e.getMessage());

        } finally {
            if (null != input) {
                try {
                    input.close();
                } catch (IOException ex) {
                    System.out.println("close error:" + ex.getMessage());

                }
            }
        }
        return null;
    }

    private int parseWindowsMsg(List<String> reponse, int total) {
        int countTrue = 0;
        int countFalse = 0;
        for (String str : reponse) {
            if (str.startsWith("来自") || str.startsWith("Reply from")) {
                countTrue++;
            }
            if (str.startsWith("请求超时") || str.startsWith("Request timed out")) {
                countFalse++;
            }
        }
        return countTrue;
    }

    private int parseLinuxMsg(List<String> reponse, int total) {
        int countTrue = 0;
        for (String str : reponse) {
            if (str.contains("bytes from") && str.contains("icmp_seq=")) {
                countTrue++;
            }
        }
        return countTrue;
    }

    /**
     * @param filepath
     * @return list
     */
    public List<String> getIpListFromTxt(String filepath) {
        BufferedReader br = null;
        List<String> iplist = new ArrayList<String>();
        try {
            File file = new File(filepath);
            br = new BufferedReader(new FileReader(file));
            while (br.ready()) {
                String line = br.readLine();
                if (null != line && !"".equals(line)) {
                    iplist.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);

        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
        return iplist;
    }

}


