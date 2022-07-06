import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Product } from '@/model/user';

export async function getSCfromUser(): Promise <Product[]> {
    const config = {
        withCredentials: true,
    } 
    try {
        const response = await axios.get(API_ROOT + '/api/user', config);
        console.log(response.data);
        return response.data;
    } catch(error) {
        return <any>error;
    }
}
