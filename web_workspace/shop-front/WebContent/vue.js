/**
 *
 */
//3개의 컴포넌트 정의
var Join = {
	template: '<div><h3>JOIN</h3>' +
		'<div><label for="id">id</label><input type="text" id="id" v-model="id" /></div>' +
		'<div><label for="pwd">pwd</label><input type="password" id="pwd" v-model="pwd" /></div>' +
		'<div><label for="name">name</label><input type="text" id="name" v-model="name" /></div>' +
		'<div><label for="email">email</label><input type="text" id="email" v-model="email" /></div>' +
		'<div><input type="radio" name="type" id="type2" value="2" v-model="type"><label for="type2">seller</label><br>' +
		'<input type="radio" name="type" id="type3" value="3" v-model="type"><label for="type3">consumer</label></div>' +
		'<button v-on:click="joinForm">join</button>' +
		'</div>',
	data: {//컴포넌트에서 사용하는 값 저장
		id: '',
		pwd: '',
		name: '',
		email: '',
		type: ''
	},
	methods: {//함수 등록
		joinForm: function() {
			alert(this.id + '/' + this.pwd + '/' + this.name + '/' + this.email + '/' + this.type);
			const form = new URLSearchParams();//폼파람 객체.
			form.append('id', this.id)
			form.append('pwd', this.pwd)
			form.append('name', this.name)
			form.append('email', this.email)
			form.append('type', this.type)
			alert(this.id + '/' + this.pwd + '/' + this.name + '/' + this.email + '/' + this.type);
			axios.post('http://localhost:8081/shop-members/', form)
				.then(function(response) {//response: 응답객체
					//alert(response.status);
					if (response.data.result) {
						this.id = response.data.join_id;
						alert('join success: join_id=' + this.id)
					} else {
						alert('join fail')
					}
				})

		},
	}
};
var Login = {
	template: '<div><h3>LOGIN</h3>' +
		'<div><label for="id">id</label><input type="text" id="id" v-model="idval" /></div>' +
		'<div><label for="pwd">pwd</label><input type="password" id="pwd" v-model="pwdval" /></div>' +
		'<button v-on:click="loginForm">login</button>' +
		'<router-link to="/join"> join</router-link>' +
		'</div>',
	data: {
		idval: '',
		pwdval: '',
		m: null
	},
	methods: {
		loginForm: function() {
			const pwdval = this.pwdval
			axios.get('http://localhost:8081/shop-members/' + this.idval)
				.then(function(response) {//response: 응답객체
					if (response.data.result) {
						this.m = response.data.data;
						if (this.m.pwd == pwdval) {
							sessionStorage.setItem("login_id", this.m.id);
							sessionStorage.setItem("type_num", this.m.type.num);
							sessionStorage.setItem("type_name", this.m.type.name);
							app.login_flag = false;
							app.$router.push('/menu' + this.m.type.num);

						} else {
							alert('pwd fail')
						}
					} else {
						alert('not found id')
					}
				})
		}
	}
};

var Menu2 = {//판매자 메뉴
	template: '<div> <p>판매자({{id}} / {{type_name}}) Menu</p>' +
			'<p><router-link to="/add-product">상품등록</router-link></p><p>{{id}}가 등록한 상품</p>'+
			'<table border="1"><tr><th>상품번호</th><th>상품제목</th><th>가격</th><th>편집</th></tr>'+	
			'<tr v-for="p in plist"><td>{{p.num}}</td><td>{{p.title}}</td><td>{{p.price}}</td>'+
			'<button v-on:click="edit">edit</button><button v-on:click="del">del</button>'+
			'</tr></table></div>',
	data (){
		return{
			id: '',
			type_num: '',
			type_name: '',
			plist: [],
		};
	},
	created: function() {
		const self = this;
		self.id = sessionStorage.getItem("login_id");
		self.type_num = sessionStorage.getItem("type_num");
		self.type_name = sessionStorage.getItem("type_name");
		axios.get('http://localhost:8081/products/' + self.id + '/members')//판매자 self.id로 등록된 상품들 검색
			.then(function(response) {//response: 응답객체
				if (response.status == 200) {//웹 응답이 정상
					if (response.data.result) {//백단의 처리 결과가 정상
						self.plist = response.data.list;
						//alert(self.plist[0].num+'/'+self.plist[0].title+'/'+self.plist[0].price);
					} else {
						alert('plist fail')
					}
				} else {
					alert('connect fail:' + response.status);
				}
			})
	},
	methods: {
		edit:function(){
			
		},
		del:function(){
			
		}
	}
};
//component
var Menu3 = {
	template: '<div> <p>구매자 Menu</p> <p>{{id}} / {{type_num}} / {{type_name}}</p></div>',
	data: {
		id: '',
		type_num: '',
		type_name: ''
	},
	created: function() {
		this.id = sessionStorage.getItem("login_id");
		this.type_num = sessionStorage.getItem("type_num");
		this.type_name = sessionStorage.getItem("type_name");
		alert(this.id + '/' + this.type_name);
	},
	methods: {}
};

var AddProduct = {
	template:'<div><h3>상품등록폼</h3>' +
	    '<div><label for="title">title</label><input type="text" id="title" v-model="title" /></div>' +
		'<div><label for="content">content</label><input type="text" id="content" v-model="content" /></div>' +
		'<div><label for="price">price</label><input type="number" id="price" v-model="price" /></div>' +
		'<div><label for="amount">amount</label><input type="number" id="amount" v-model="amount" /></div>' +
		'<div><label for="file1">상품사진</label><input type="file" ref="file1"/>'+
		'<input type="file" ref="file2"/><input type="file" ref="file3"/><input type="file" ref="file4"/></div>' +		
		'<p><label for="cate">카테고리 선택</label><select id="cate" v-model="cate">'+
		'<option v-for="c in cates" v-bind:value="c.num">{{c.name}}</option></select></p>'+
		'<button v-on:click="add">등록</button>' +
		'</div>',
	data(){//반응형. 값이 갱신되면 화면도 갱신
		return{
			cates:[],
			title:'',
			content:'',
			price:0,
			amount:0,
			cate:'',		
		};	
	},
	created:function(){
		const self = this;
		axios.get('http://localhost:8081/cates/')
			.then(function(response) {
				if (response.status == 200) {
					if (response.data.result) {
						self.cates = response.data.list;
					} else {
						alert('plist fail')
					}
				} else {
					alert('connect fail:' + response.status);
				}
			})
	},
	methods:{
		add:function(){
			//title, content, seller, price, amount, cate, file1~4
			const form = new FormData();//폼파람 객체.
			form.append('title', this.title)
			form.append('content', this.content)
			form.append('seller', sessionStorage.getItem("login_id"))
			form.append('price', this.price)
			form.append('amount', this.amount)
			form.append('cate', this.cate)
			if(this.$refs.file1.files[0]!=null)
				form.append('file1', this.$refs.file1.files[0])
			if(this.$refs.file2.files[0]!=null)
				form.append('file2', this.$refs.file2.files[0])
			if(this.$refs.file3.files[0]!=null)
				form.append('file3', this.$refs.file3.files[0])
			if(this.$refs.file4.files[0]!=null)
				form.append('file4', this.$refs.file4.files[0])
			
			axios.post('http://localhost:8081/products/', form, {headers:{'Content-Type':'multipart/form-data'}})
				.then(function(response) {//response: 응답객체
					//alert(response.status);
					if (response.data.result) {
						alert('등록완료')
						app.$router.push('/menu2');
					} else {
						alert('등록실패')
					}
				})
		}
	}
}

//라우터 등록
var routes = [{
	path: '/join',
	component: Join
}, {
	path: '/login',
	component: Login
}, {
	path: '/menu2',
	component: Menu2
}, {
	path: '/menu3',
	component: Menu3
}, {
	path: '/add-product',
	component: AddProduct
}];

//라우터 객체 생성
var router = new VueRouter({
	routes
});

//뷰 객체
var app = new Vue({
	router,
	data: {
		login_flag: true
	},
	created: function() {
		var xx = sessionStorage.getItem("login_id");
		if (xx == '' || xx == null) {
			this.login_flag = true;
		} else {
			this.login_flag = false;
		}
	},
	methods: {
		logout: function() {
			this.login_flag = true;
			sessionStorage.removeItem("login_id");
			sessionStorage.removeItem("type_num");
			sessionStorage.removeItem("type_name");
			location.href = 'index.html'
		}
	}
}).$mount('#app');
