<template>
    <div class="max-w-xs h-fit p-3 bg-slate-50 rounded-md w-1/3 flex flex-col items-center gap-4">
        <div class="w-full h-1/5 flex justify-center items-center">
            <h1 class="font-semibold text-2xl">Login</h1>
        </div>
        <div class="w-full h-full flex flex-col gap-5">
            <div class="flex flex-col">
                <label for="" class="text-lg">Email</label>
                <input v-model="email" type="email" class="input bg-slate-800 p-2 text-sm text-white rounded-md">
            </div>
            <div class="flex flex-col">
                <label for="" class="text-lg">Password</label>
                <input v-model="password" type="text" class="input bg-slate-800 p-2 text-sm text-white rounded-md">
            </div>
            <div class="flex flex-col">
                <label for="" class="text-lg">Kode</label>
                <input v-model="kode" type="text" class="input bg-slate-800 p-2 text-sm text-white rounded-md">
            </div>
        </div>
        <div class="w-full">
            <button @click="loginAdmin"
                class="w-full bg-blue-700 text-white rounded-md p-2 duration-700 hover:bg-green-700 hover:scale-95">Submit</button>
        </div>
    </div>
</template>
<script>
import axios from 'axios'
import { mapMutations } from 'vuex'
export default {
    data() {
        return {
            email: '',
            password: '',
            kode: ''
        }
    },
    methods: {
        ...mapMutations(['setLoggedIn', 'setAdminEmail', 'setAdminPassword', 'setAdminKode']),
        loginAdmin() {
            const admin = {
                email: this.email,
                password: this.password,
                kode: this.kode
            }
            axios.post(`http://localhost:8123/api/v1/admin/login`, admin)
                .then(response => {
                    this.setAdminEmail(admin.email);
                    this.setAdminPassword(admin.password);
                    this.setAdminKode(admin.kode);
                    this.setLoggedIn(true)
                    this.$router.push("/")

                })
                .catch(err => console.log(err))
        },
        test() {
            console.log(localStorage.getItem('isLoggedIn'));
        }
    },
    mounted() {
        const isLoggedIn = localStorage.getItem('isLoggedIn')
        if (isLoggedIn) {
            this.$store.commit('setLoggedIn', true)
        } else {
            this.$store.commit('setLoggedIn', false)
        }
    }
}
</script>
<style scoped>
.input {
    letter-spacing: 2px;
    transition: 1s ease-in-out;
}

.input:focus {
    outline-width: 4px;
    outline-color: #5c5c5c;
    background-color: #fff;
    color: #1c1c1c;
    border: 4px;
}
</style>