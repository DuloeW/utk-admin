<template>
    <div class="w-10/12 h-10/12 flex justify-center items-center relative">
        <RouterLink to="/">
            <BackButton class="absolute top-0 left-0 text-base p-2 text-white m-2" />
        </RouterLink>
        <form class="w-full h-full p-4 overflow-hidden flex flex-col justify-center items-center">
            <div class="input-data">
                <label for="">Nama Panjang</label>
                <input v-model="namaPanjang" type="text" maxlength="50" minlength="10" required>
            </div>
            <div class="input-data">
                <label for="">NISN</label>
                <input v-model="nisn" type="number" max="999999999999" min="1000000000" required>
            </div>
            <div class="input-data">
                <label for="">Tanggal Minjam</label>
                <input type="date" v-model="tglMinjam" required>
            </div>
            <div @click="getTglKembali" class="input-data">
                <label for="">Tanggal Kembali</label>
                <span class="w-full h-fit p-2 bg-white rounded-sm">
                    <p>{{ tglKembali == '' || tglKembali == 'NaN/NaN/NaN' ? 'klik ini setelah isi data tgl minjam' : tglKembali}}</p>
                </span>
            </div>
            <div class="input-data w-full">
                <label for="">Jumlah Buku</label>
                <input v-model="jumlahBuku" type="number" max="2" min="1" required>
            </div>
            <div class="text-white mt-3">
                <button @click="createPeminjam" class="btn-kiri px-2 bg-green-700 rounded">Kirim</button>
                <input type="reset" value="hapus" class="btn-kanan px-2 bg-red-700 ml-2 rounded">
            </div>
        </form>
    </div>
</template>
<script>
import axios from 'axios';
import { RouterLink } from 'vue-router';
import BackButton from '../components/icons/back_button.vue'

export default {
    setup() {
        return {
            RouterLink
        }
    },
    data() {
        return {
            namaPanjang: '',
            nisn: '',
            tglMinjam: '',
            tglKembali: '',
            jumlahBuku: ''
        }
    },
    components: {
        BackButton
    },
    methods: {
        async createPeminjam() {
            try {
                const response = await axios.post('http://localhost:8123/api/v1/peminjam/create', {
                    namaLengkap: this.namaPanjang,
                    nisn: this.nisn,
                    tanggalMinjam: this.tglMinjam,
                    tanggalKembali: this.tglKembali,
                    jumlahBuku: this.jumlahBuku
                })
                console.log(response.data);
            } catch (err) {
                console.error(err.response.data);
            }
        }
    },
    computed: {
        getTglKembali() {
            const todayDate = new Date(this.tglMinjam.toString());
            const nexWeek = new Date(todayDate.getFullYear(), todayDate.getMonth(), todayDate.getDate() + 7);
            this.tglKembali = `${nexWeek.getDate()}/${nexWeek.getMonth()+1}/${nexWeek.getFullYear()}`;
        }
    }
}

</script>

<style scoped>

label {
    font-weight: bolder;
    letter-spacing: 2px;
    font-size: 15px;
}

.input-data {
    width: 80%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    margin: 10px;
    padding: 8px;
    background: #ebebeb;
    border-radius: 10px;
}

.input-data input {
    size: 100%;
    border: none;
    outline: none;
    padding: 8px;
    border-radius: 5px;
    font-size: 14px;
}

.btn-kiri {
    animation: hideSlideRight 5s ease-in forwards;
}
.btn-kanan {
    animation: hideSlideLeft 5s ease-in forwards;
}

.input-data:nth-child(1) {
    animation: fadeIn 1s ease-in forwards;
}
.input-data:nth-child(2) {
    animation: fadeIn 2s ease-in forwards;
}
.input-data:nth-child(3) {
    animation: fadeIn 3s ease-in forwards;
}
.input-data:nth-child(4) {
    animation: fadeIn 4s ease-in forwards;
}
.input-data:nth-child(5) {
    animation: fadeIn 5s ease-in forwards;
}

@keyframes hideSlideRight {
    from {
        transform: translateX(-100%);
        opacity: 0;
    }
    to {
        transform: translateX(0);
        opacity: 1;
    }
}
@keyframes hideSlideLeft {
    from {
        transform: translateX(100%);
        opacity: 0;
    }
    to {
        transform: translateX(0);
        opacity: 1;
    }
}
@keyframes fadeIn {
    from{
        opacity: 0;
        transform: scale(.5);
    }
    to {
        opacity: 1;
        transform: scale(1);
    }
}
</style>