import axios from 'axios'
const request = axios.create({
  //是baseURL不是baseUrl！！！！！！！！！！
  baseURL: 'http://localhost:7071' , //全局统一加上了前缀,所有接口都会加上前缀,页面里写接口不要加
  timeout: 5000
})

// request 拦截器
// 可以自动请求发送前对请求做一些处理
// 统一加token，对请求参数统一加密
request.interceptors.request.use(config =>{
  config.headers['Content-Type'] = 'application/json;charset=utf-8';

  // config.headers['token'] = user.token // 设置请求头
  return config
},error => {
  return Promise.reject(error)
});

// response 拦截器
// 可以在接口响应后统一处理结果
request.interceptors.response.use(
  response => {
    let res = response.data;
    if(res.status != 200){
      alert(res.message)
    }
    // 兼容服务端返回的字符串数据
    if(typeof res === 'string'){
      res = res ? JSON.parse(res) : res
    }
    return res;
  },
  error => {
    console.log('err' + error) // for debug
    return Promise.reject(error)
  }
)
export default request
