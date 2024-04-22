import axios, {type AxiosInstance, type AxiosRequestConfig} from "axios";
import {ElMessage} from "element-plus";

export default class AxiosHttpClient {
    private readonly client: AxiosInstance = axios.create({
        timeout: 3000,
        timeoutErrorMessage: "request timeout",
    })

    public request(config: AxiosRequestConfig){
        return this.client.request(config)
            .catch(e =>{
                const errorMessage = e.response?.data?.message || e.message
                return Promise.reject(errorMessage)
            })
    }
}