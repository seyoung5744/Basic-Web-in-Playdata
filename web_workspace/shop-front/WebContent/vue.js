/**
 *
 */
//3개의 컴포넌트 정의
var Join = {
    template: '<div>'+
			'<div><label for="id">id</label><input type="text" id="id" v-model="id" /></div>'+
      '<div><label for="pwd">pwd</label><input type="password" id="pwd" v-model="pwd" /></div>'+
      '<div><label for="name">name</label><input type="text" id="name" v-model="name" /></div>'+
      '<div><label for="email">email</label><input type="text" id="email" v-model="email" /></div>'+
      '<div><input type="radio" name="type" id="type2" value="2" v-model="type"><label for="type2">seller</label><br>'+
      '<input type="radio" name="type" id="type3" value="3" v-model="type"><label for="type3">consumer</label></div>'+
      '<button v-on:click="joinForm">join</button>'+
      '</div>',
    data: {//컴포넌트에서 사용하는 값 저장
      id: '',
		  pwd:'',
		  name:'',
  		email:'',
      type:''
  	},
    methods: {//함수 등록
      joinForm: function () {
        alert(this.id+'/'+this.pwd+'/'+this.name+'/'+this.email+'/'+this.type);
        const form = new URLSearchParams();//폼파람 객체.
        form.append('id', this.id)
        form.append('pwd', this.pwd)
        form.append('name', this.name)
        form.append('email', this.email)
        form.append('type', this.type)
        alert(this.id+'/'+this.pwd+'/'+this.name+'/'+this.email+'/'+this.type);
		      axios.post('http://localhost:8081/shop-members/', form)
            .then(function(response) {//response: 응답객체
        	     alert(response.status);
        	     if(response.data.result){
                 this.id = response.data.join_id;
				          alert('join success: join_id='+this.id)
        	     }else{
        		      alert('join fail')
        	     }
    	})

    },
  }
};
var Login = {
    template: '<div> Login </div>'
};
var Menu = {
    template: '<div> Menu </div>'
};

//라우터 등록
var routes = [{
    path: '/join',
    component: Join
	}, {
    path: '/login',
    component: Login
	},{
    path: '/menu',
    component: Menu
}];

//라우터 객체 생성
var router = new VueRouter({
    routes
});

//뷰 객체
var app = new Vue({
    router
}).$mount('#app');
