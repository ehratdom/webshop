import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { ProductinCart } from '@/model/productincart';


export async function deleteProductInCart(id: number): Promise<ProductinCart[]> {
    
    const config = {        
        withCredentials: true
    }
    try {
        const response = await axios.delete(API_ROOT + '/api/deleteitem/' + id, config);
        console.log(response.data)
        return response.data;
    } catch (error) {
        return <any>error;   
    }

}