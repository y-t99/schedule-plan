import { defineStore, } from 'pinia';

export const userInfo = defineStore(
    'userInfo', {
        state() {
            return {
                id: null,
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
                this.id = userInfo.id;
                this.account = userInfo.account;
                this.name = userInfo.name;
                this.avatar = userInfo.avatar;
                this.email = userInfo.email;
                this.saying = userInfo.saying;
                this.likedBook = userInfo.likedBook;
                this.likedThing = userInfo.likedThing;
            },
        }
    })
export const BASE_PATH = "http://localhost:8088";