import { request } from "./RequestAOP";

const LOGIN_PATH = "/user/login";

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