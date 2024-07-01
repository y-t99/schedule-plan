import { defineStore, } from 'pinia';

export const userInfo = defineStore(
    'userInfo', {
        state() {
            return {
                account: null,
                name: null,
                avatar: null,
                email: null,
                token: null,
                isLogin: false,
            }
        },
        actions: {
            setToken(token) {
                this.token = token
                this.isLogin = true
            },
            setUserInfo(userInfo) {
                this.account = userInfo.account;
                this.name = userInfo.name;
                this.avatar = userInfo.avatar;
                this.email = userInfo.email;
            },
        }
    })
export const BASE_PATH = "http://localhost:8087";