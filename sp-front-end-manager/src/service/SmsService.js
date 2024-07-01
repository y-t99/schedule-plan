import { request } from "./RequestAOP";

const FACTOR_CATEGORY = "/factor-category";
const FACTOR = "/factor";
const FACTOR_CATEGORY_QUERY_ALL = FACTOR_CATEGORY + "/queryAll";
const FACTOR_CREATER_PATH = FACTOR + "/create";
const FACTOR_QUERY_ALL_PATH = FACTOR + "/all";
const FACTOR_QUERY_CATEGORY_ID = FACTOR + "/list/category-id";
const FACTOR_QUERY_ID = FACTOR;
const FACTOR_UPDATE = FACTOR;

/**
 * @returns 获取全部的因素分类信息
 */
export const factorCategoryQueryAll = () => {
    return request({
        url: FACTOR_CATEGORY_QUERY_ALL,
        method: "get"
    })
}

/**
 * 创建因素
 * @param {*} factor  创建因素
 * @returns 数据库增加行数
 */
export const factorCreate = (factor) => {
    const data = factor;
    return request({
        url: FACTOR_CREATER_PATH,
        method: "post",
        data
    })
}

/**
 * 
 * @returns 查找所有因素详细信息
 */
export const factorQueryAll = () => {
    return request({
        url: FACTOR_QUERY_ALL_PATH,
        method: "get"
    })
}

/**
 * 根据分类id查找因素
 * @param {*} categoryId 
 * @returns 
 */
export const factorQueryByCategoryId = (categoryId) => {
    return request({
        url: FACTOR_QUERY_CATEGORY_ID + "/" + categoryId,
        method: "get"
    })
}

/**
 * 根据因素id查找因素详细信息
 * @param {*} id 
 * @returns 
 */
export const factorQueryById = (id) => {
    return request({
        url: FACTOR_QUERY_ID + "/" + id,
        method: "get"
    })
}

/**
 * 更改因素信息
 * @param {*} data 
 * @returns 
 */
export const factorUpdate = (data) => {
    return request({
        url: FACTOR_UPDATE + "/" + data.id,
        method: "put",
        data
    })
}