import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { User } from '@/model/user';

export async function getSCfromUser(): Promise <User[]> {
    const config = {
        withCredentials: true,
    } 
    try {
        const response = await axios.get(API_ROOT + '/api/users', config);
        console.log(response.data);
        return response.data;
    } catch(error) {
        return <any>error;
    }
}
