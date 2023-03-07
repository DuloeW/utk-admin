<template>
    <div class="h-full w-full">
        <div class="flex w-full h-full">
            <div class="w-2/4 h-full bg-white flex flex-col justify-between gap-4 items-center p-5 ">
                <div class="w-full h-fit bg-white shadow-2xl shadow-slate-300 rounded-lg flex justify-center">
                    <PersonIcon class="text-9xl" />
                </div>
                <div class="h-5/6 w-full p-5 bg-white shadow-xl flex flex-col shadow-slate-300 rounded-t-xl relative">
                    <span class="info-admin">
                        <h3>Nama Admin</h3>
                        <p>I Putu Bayu Gelgel wiyantara</p>
                    </span>
                    <span class="info-admin">
                        <h3>Email Admin</h3>
                        <p>iputubayu721@gmail.com</p>
                    </span>
                    <span class="info-admin">
                        <h3>Kode Admin</h3>
                        <p>sjd93Mjsj2</p>
                    </span>
                    <span class="flex mt-5 w-full justify-evenly">
                        <RouterLink to="/" class="px-5 py-3 bg-blue-700 rounded-md font-semibold text-white">
                            <button class="tracking-wider">Back</button>
                        </RouterLink>
                        <button @click="logOut"
                            class="px-5 py-3 bg-red-700 rounded-md font-semibold text-white tracking-wider">Logout</button>
                    </span>
                    <img src="../../public/Picture1.png" alt=""
                        class="absolute -right-32 p-5 bg-white rounded-full shadow-lg shadow-slate-200">
                </div>
            </div>
            <div class="w-2/4 h-full p-5">
                <span>
                    <h1 class="text-white font-semibold text-4xl tracking-widest">{{ title.toLocaleUpperCase() }}</h1>
                    <p class="text-slate-100 tracking-[4px] text-xs">{{ perpus }}</p>
                </span>
            </div>
        </div>
    </div>
</template>
<script>
import { RouterLink } from 'vue-router';
import BackButton from '../components/icons/back_button.vue';
import PersonIcon from 'vue-ionicons/dist/md-person.vue';
import { mapMutations } from 'vuex';
export default {
    setup() {
        return {
            RouterLink
        }
    },
    data() {
        return {
            title: 'Smk Negeri 2 Tabanan',
            perpus: 'perpustakaan yang sangat maju dan lengkap'
        }
    },
    components: {
        BackButton,
        PersonIcon
    },
    methods: {
        ...mapMutations(['setLogOut', 'setAdminEmail', 'setAdminPassword', 'setAdminKode']),
        logOut() {
            this.setAdminEmail(null);
            this.setAdminPassword(null);
            this.setAdminKode(null);
            this.setLogOut(false)
            this.$router.push('/login');
        }

    }
}
</script>
<style scoped>
.info-admin {
    width: 100%;
    height: fit-content;
    /* background: #3bffad; */
    display: flex;
    flex-direction: column;
    padding: 20px;
    border-bottom: 2px solid #dadada;
}

.info-admin h3 {
    font-size: 25px;
}

.info-admin p {
    margin-top: 5px;
}
</style>