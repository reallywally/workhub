import axios, {AxiosError, type AxiosInstance, type AxiosRequestConfig} from "axios";
import {ElMessage} from "element-plus";

export type HttpRequestConfig = {
    method?: 'GET' | 'POST' | 'PUT' | 'PATCH'|  'DELETE',
    path: string,
    params?: any,
    body?: any,
}


export default class AxiosHttpClient {
    private readonly client: AxiosInstance = axios.create({
        timeout: 3000,
        timeoutErrorMessage: "request timeout",
    })

    private request(config: HttpRequestConfig){
        return this.client.request({
            method: config.method,
            url: config.path,
            params: config.params,
            data: config.body,
        }).catch((e: AxiosError) => {
            return Promise.reject(e)
        })
    }

    public async get(config: HttpRequestConfig){
        return this.request({...config, method: 'GET'})
    }

    public async post(config: HttpRequestConfig){
        return this.request({...config, method: 'POST'})
    }

    public async put(config: HttpRequestConfig){
        return this.request({...config, method: 'PUT'})
    }

    public async patch(config: HttpRequestConfig){
        return this.request({...config, method: 'PATCH'})
    }

    public async delete(config: HttpRequestConfig){
        return this.request({...config, method: 'DELETE'})
    }
}