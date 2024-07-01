import { request } from "./RequestAOP";

const LOGIN_PATH = "/user/login";
const REGISTER_PATH = "/user/register";

export const login = (account, password) => {
    const data = {
        account,
        password,
    }
    return request({
        url: LOGIN_PATH,
        method: "post",
        data
    })
}

export const register = (data) => {
    return request({
        url: REGISTER_PATH,
        method: "post",
        data
    })
}