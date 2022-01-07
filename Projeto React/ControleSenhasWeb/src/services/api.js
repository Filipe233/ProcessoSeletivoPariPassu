import axios from 'axios';

const api = axios.create({
    baseURL: "http://localhost:8080/",
});

api.interceptors.request.use(async config => {

    config.headers = {
        "Access-Control-Allow-Origin": '*',
        "Content-Type": "application/json",
    };
    return config;
});

api.interceptors.response.use(function (response) {
    return response;
}, function (error) {
    return Promise.reject(error);
});

export default api;
//querystring path  buffer crypto fs stream http net