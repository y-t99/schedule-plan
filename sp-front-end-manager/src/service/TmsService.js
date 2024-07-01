import { request } from "./RequestAOP";

const DataSheet_meta = "/datasheet-meta";

const ALL_Metas = DataSheet_meta + "/all";

export const datasheetMetaQueryAll = () => {
    return request({
        url: ALL_Metas,
        method: "get"
    })
}