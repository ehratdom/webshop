import { getSCfromUser } from '@/api/users';
import { User } from '@/model/user';
import { onMounted, ref } from 'vue';

export function useUsers() {

    const users = ref<User[]>([]);

    const getUsers = async () => {
        try {
            users.value = await getSCfromUser();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getUsers);

    return {
        users
    }
}
