axios.defaults.baseURL = '/first-spring-boot_01';
if(localStorage.length > 0 && sessionStorage.length <= 0) {

	sessionStorage.setItem("userId", resultdata.data.userInfo.id);
	sessionStorage.setItem("username", resultdata.data.userInfo.username);
	sessionStorage.setItem("accessToken", resultdata.data.accessToken);
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

/*点击小图弹出大图*/
$(document).on('click', '.busin_img > a', function() {
	console.log('点击小图显示大图')
	var img = $(this).find('img');
	var imgsrc1 = img.attr('src');
	console.info(imgsrc1);
	var imgHtml = '<img class="imgshowbox" src="' + imgsrc1 + '"/>';
	top.layer.open({
		type: 1,
		title: false, //不显示标题
		shadeClose: true,
		closeBtn: 1,
		move: true,
		area: ['600px', ''],
		// area: [img.width + 'px', img.height+'px'],
		content: imgHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
		cancel: function() {}
	})
})
$(function() {
	//上传图片的缩略图
	$('.input_opt').change(function(e) {
		var imgName = e.target.files[0].name; //获取上传的文件名 
		var paren = $(this).parent('.img_thumb');
		var divObj = paren.find('b');
		// console.log(imgName+'获取的888文件名');
		paren.find('i').remove();
		divObj.html('');
		var file = e.target.files[0];
		if(window.FileReader) {
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onloadend = function(e) {
				divObj.append('<img src="' + e.target.result + '">');
				paren.append('<i>x</i>');
			}
		}
	})
	$(document).on('click', '.img_thumb >i', function() {
		$(this).parent('p').find('b').html('');
		// console.log($(this).siblings('.input_opt').val()+'获取22226的长度');
		$(this).siblings('.input_opt').val('');
		// console.log($(this).siblings('.input_opt').val()+'获取688866的长度');
		$(this).remove();
	})
})