import { request } from "./RequestAOP";
const SCHEDULE_BASE_ROW_BASE_PATH = "/schedule-base-row";
const SCHEDULE_CARD_BASE_PATH = "/schedule-card";
const SCHEDULE_RECTOR_BASE_PATH = "/schedule-rector";
const SCHEDULE_DATA_VIEW = "/schedule-data-view";
const ROW_META = SCHEDULE_BASE_ROW_BASE_PATH + '/schedule-row-meta';
const CARD = SCHEDULE_CARD_BASE_PATH + "/getCard";
const CREATE_ROW = SCHEDULE_BASE_ROW_BASE_PATH + "/create";
const ROWS_BY_GROUP = SCHEDULE_DATA_VIEW + "/getRowsByGroup";
const FACTOR_META = SCHEDULE_RECTOR_BASE_PATH + "/meta";
const PUSH_FACTOR = SCHEDULE_RECTOR_BASE_PATH + "/push-factor";
const FACTOR_VALUE = SCHEDULE_RECTOR_BASE_PATH + "/factor-value";
const PUSH_ROW = SCHEDULE_BASE_ROW_BASE_PATH + "/push-row";
const TOGGLE_FINISH = SCHEDULE_BASE_ROW_BASE_PATH + "/toggle-finish-statue";
const TOGGLE_DELAY = SCHEDULE_BASE_ROW_BASE_PATH + "/toggle-delay-statue";



export const getRowMeta = () => {
    return request({
        url: ROW_META,
        method: "get",

    });
}

export const getFactorValue = (rowId) => {
    return request({
        url: FACTOR_VALUE,
        method: "get",
        async: false,
        data: {
            rowId,
        }
    });
}

export const getFactorMeta = (factorCategoryId) => {
    return request({
        url: FACTOR_META,
        method: "get",
        async: false,
        data: {
            factorCategoryId
        },
    });
}



export const queryCard = (userId, cardSn) => {
    return request({
        url: CARD,
        method: "get",
        data: {
            userId,
            cardSn
        }
    });
}

export const createCardRow = (data) => {
    return request({
        url: CREATE_ROW,
        method: "post",
        data
    });
}

export const pushFactor = (data) => {
    return request({
        url: PUSH_FACTOR,
        method: "post",
        data
    });
}

export const putFactor = (data) => {
    return request({
        url: PUSH_FACTOR,
        method: "put",
        data
    });
}

export const toggleFinish = (rowId, statue) => {
    return request({
        url: TOGGLE_FINISH,
        method: "put",
        data: {
            rowId,
            statue,
        }
    });
}

export const toggleDelay = (rowId, statue) => {
    return request({
        url: TOGGLE_DELAY,
        method: "put",
        data: {
            rowId,
            statue,
        }
    });
}

export const putRow = (data) => {
    return request({
        url: PUSH_ROW,
        method: "put",
        data
    });
}

export const queryRowsByGroup = (userId, cardSn, group) => {
    return request({
        url: ROWS_BY_GROUP,
        method: "get",
        data: {
            userId,
            cardSn,
            group
        }
    });
}