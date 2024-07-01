import { request } from "./RequestAOP";
const DATASHEET_BASE_PATH = "/datasheet";
const ADD_DATASHEET = DATASHEET_BASE_PATH + "/add-datasheet"
const QUERY_ALL_DATASHEET_META = DATASHEET_BASE_PATH + "/query-all-datasheet-meta"
const ADD_DATA_STORAGE = DATASHEET_BASE_PATH + "/add-data-storage";
const QUERY_DATA_STORAGE = DATASHEET_BASE_PATH + "/query-data-storage";

export const addDatasheet = (datasheetStructureDTO) => {
    return request({
        url: ADD_DATASHEET,
        method: "post",
        data: datasheetStructureDTO
    });
}

export const addDataStorage = (dataStorageDTO) => {
    return request({
        url: ADD_DATA_STORAGE,
        method: "post",
        data: dataStorageDTO
    });
}

export const queryAllDatasheetMeta = (userId) => {
    return request({
        url: QUERY_ALL_DATASHEET_META,
        method: "get",
        data: {
            userId
        }
    });
}

export const queryDataStorage = (dstId) => {
    return request({
        url: QUERY_DATA_STORAGE,
        method: "get",
        data: {
            dstId
        }
    });
}