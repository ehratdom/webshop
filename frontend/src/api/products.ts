import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Product } from '@/model/product';

export async function getAllProducts(): Promise <Product[]> {
    const config = {
        withCredentials: true,
    } 
    try {
        const response = await axios.get(API_ROOT + '/api/products', config);
        return response.data;
        console.log(response.data)
    } catch(error) {
        return <any>error;
    }
}
