axios.defaults.baseURL = '/hm';
if(localStorage.length > 0 && sessionStorage.length <= 0) {

	sessionStorage.setItem("accessToken", localStorage.accessToken);
	sessionStorage.setItem("userCode", localStorage.userCode);
	sessionStorage.setItem("userName", localStorage.userName);
	sessionStorage.setItem("userType", localStorage.userType);
	sessionStorage.setItem("refCode", localStorage.refCode);
	sessionStorage.setItem("menus", localStorage.menus);
}

// http request 拦截器
axios.interceptors.request.use(
	config => {

		if(sessionStorage.accessToken) { // 判断是否存在token，如果存在的话，则每个http header都加上token
			//			config.headers.Authorization = `token ${localStorage.JWT_TOKEN}`;
			//			config.headers.accessToken = `token ${localStorage.accessToken}`;
			config.headers.accessToken = sessionStorage.accessToken;

		}
		return config;
	},
	err => {
		return Promise.reject(err);
	});

// http response 拦截器
axios.interceptors.response.use(
	response => {
		return response;
	},
	error => {
		if(error.response) {
			console.log('axios:' + error.response.status);
			switch(error.response.status) {
				case 401:
					// 返回 401 清除token信息并跳转到登录页面
					//store.commit('LOG_OUT');
					//        router.replace({
					//          path: 'login',
					//          query: {redirect: router.currentRoute.fullPath}
					//        });

					logout();
					parent.location.href = "../../login.html?returnUrl=" + top.location.href;
					break;

				default:
					if(error.response.data.message) {
						alert(error.response.data.message);
					} else {
						alert("出错啦");
					}
					break;
			}
		}
		return Promise.reject(error.response.data); // 返回接口返回的错误信息
	});

Vue.prototype.$http = axios;

function logout() {
	//	sessionStorage.removeItem("accessToken");
	//	sessionStorage.removeItem("userCode");
	//	sessionStorage.removeItem("userName");
	//	sessionStorage.removeItem("userType");
	//	sessionStorage.removeItem("setRefCode");
	sessionStorage.clear();
	localStorage.clear();
}

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
}