import { request } from "./RequestAOP";

const NOTIFY_LIST = "/work-table/notice/list";
const NOTICE = "/work-table/notice";
const DEFAULT_LOG = "/work-table/defaultLogs"
const LOGS = "/work-table/logs"
const LOG = "/work-table/log";
const REMOVE_LOG = "/work-table/log"

export const notifyList = () => {
    return request({
        url: NOTIFY_LIST,
        method: "get"
    })
}


export const notice = () => {
    return request({
        url: NOTICE,
        method: "get"
    })
}

export const removeLog = (id) => {
    return request({
        url: REMOVE_LOG + "/" + id,
        method: "delete"
    })
}

export const defaultLogs = () => {
    return request({
        url: DEFAULT_LOG,
        method: "get"
    })
}

export const logs = () => {
    return request({
        url: LOGS,
        method: "get"
    })
}

export const log = (title, content, version, type) => {
    return request({
        url: LOG,
        method: "post",
        data: {
            title,
            content,
            version,
            type,
        }
    })
}

export const pushNotice = (title, content) => {
    return request({
        url: NOTICE,
        method: "put",
        data: {
            title,
            content
        }
    })
}