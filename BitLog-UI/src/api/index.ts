/**
 *  index.ts作为api接口的统一出口
 * */
//  axios封装为request，提供请求拦截和响应拦截功能
import * as request from '@/api/axios'
//  status存储不同后端返回码所对应的响应方式
import * as status from '@/api/status'
export default {
  request,
  status
}
