/* 
对请求进行增强：
*/

import axios from 'axios'
import { BASE_PATH, userInfo } from './config'

// 创建axios实例
const service = axios.create({
    baseURL: BASE_PATH, // api的base_url
    timeout: 5000, // 请求超时时间
})

// request拦截器
service.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=UTF-8;';
    if (userInfo().isLogin) {
        config.headers['Authorization'] = userInfo().token
    }
    if (config.method === 'POST') {
        config.data = JSON.stringify(config.data);
    }
    return config
}, error => {
    // Do something with request error
    console.log(error) // for debug
    Promise.reject(error)
})

// respone拦截器
service.interceptors.response.use(
    response => response,
    /**
     * 下面的注释为通过response自定义code来标示请求状态，当code返回如下情况为权限有问题，登出并返回到登录页
     * 如通过xmlhttprequest 状态码标识 逻辑可写在下面error中
     */
    //  const res = response.data;
    //     if (res.code !== 20000) {
    //       Message({
    //         message: res.message,
    //         type: 'error',
    //         duration: 5 * 1000
    //       });
    //       // 50008:非法的token; 50012:其他客户端登录了;  50014:Token 过期了;
    //       if (res.code === 50008 || res.code === 50012 || res.code === 50014) {
    //         MessageBox.confirm('你已被登出，可以取消继续留在该页面，或者重新登录', '确定登出', {
    //           confirmButtonText: '重新登录',
    //           cancelButtonText: '取消',
    //           type: 'warning'
    //         }).then(() => {
    //           store.dispatch('FedLogOut').then(() => {
    //             location.reload();// 为了重新实例化vue-router对象 避免bug
    //           });
    //         })
    //       }
    //       return Promise.reject('error');
    //     } else {
    //       return response.data;
    //     }
    error => {
        console.log('err' + error) // for debug
        Message({
            message: error.message,
            type: 'error',
            duration: 5 * 1000
        })
        return Promise.reject(error)
    })

/**
 * @param {String} method  请求的方法：get、post、delete、put
 * @param {String} url     请求的url:
 * @param {Object} data    请求的参数
 * @param {Object} config  请求的配置
 * @returns {Promise}     返回一个promise对象，其实就相当于axios请求数据的返回值
 */
export const request = ({
    method,
    url,
    data,
    config
}) => {
    method = method.toLowerCase();
    if (method == 'post') {
        return service.post(url, data, {...config })
    } else if (method == 'get') {
        return service.get(url, {
            params: data,
            ...config
        })
    } else if (method == 'delete') {
        return service.delete(url, {
            params: data,
            ...config
        })
    } else if (method == 'put') {
        return service.put(url, data, {...config })
    } else if (method == 'put') {
        return service.options(url, data, {...config })
    } else {
        console.error('未知的method' + method)
        return false
    }
}