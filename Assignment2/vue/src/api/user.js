import request from '@/request'

export default {
  /**
   * 1.登录
   * @param {*} param
   * @returns
   */
  login (param) {
    return request({
      url: '/user/login',
      method: 'post',
      data: param
    })
  },

  /**
   * 2.注册
   * @param {*} param
   * @returns
   */
  register (param) {
    return request({
      url: '/user/register',
      method: 'post',
      data: param
    })
  },

  /**
   * 3.找回密码
   * @param {*} param
   * @returns
   */
  createorder (param) {
    return request({
      url: '/user/createOrder',
      method: 'post',
      data: param
      ,
      headers:{
        'token' :window.localStorage['token']
      }
    })
  },

  /**
   * 4.仓库初始化
   */
  checkOrder(param) {
    return request({
      url: '/user/tracking',
      method: 'post',
      data: param,
      headers:{
        'token' :window.localStorage['token']
      }
    })
  }

}
