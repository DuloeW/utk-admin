<template>
    <div class="w-10/12 h-10/12 flex justify-center items-center relative">
        <RouterLink to="/">
            <BackButton class="absolute top-0 left-0 text-base p-2 text-white m-2" />
        </RouterLink>
        <AlertMessage v-if="someThingHappend" :message="message" :class="isWrongClass" class="absolute top-50 z-10" />
        <form class="w-full h-full p-4 overflow-hidden flex flex-col justify-center items-center">
            <div class="input-book">
                <label for="">Judul Buku</label>
                <input v-model="judulBuku" type="text" required>
            </div>
            <div class="input-book">
                <label for="">Kode Buku</label>
                <input v-model="kodeBuku" type="text" maxlength="5" minlength="5" required>
            </div>
            <div class="input-book">
                <label for="">Kategori</label>
                <select v-model="kategori" name="" id="">
                    <option value="pendidikan">
                        Pendidikan
                    </option>
                    <option value="hiburan" selected>
                        Hiburan
                    </option>
                    <option value="berita">
                        Berita
                    </option>
                </select>
            </div>
            <div class="input-book">
                <label for="">Tahun Rilis</label>
                <input v-model="tahunRilis" type="date" required>
            </div>
            <div class="input-book">
                <label for="">Deskripsi</label>
                <textarea v-model="deskripsi" name="" id="" cols="2" rows="3" required></textarea>
            </div>
            <div class="text-white mt-3">
                <button @click.prevent="createBook" class="btn-kiri px-2 bg-green-700 rounded">Kirim</button>
                <input type="reset" value="hapus" class="btn-kanan px-2 bg-red-700 ml-2 rounded">
            </div>
        </form>
    </div>
</template>

<script>
import axios from 'axios';
import { RouterLink } from 'vue-router';
import BackButton from '../components/icons/back_button.vue'
import PendidikanIcon from '../components/icons/student.vue'
import BeritaIcon from '../components/icons/news.vue'
import GameIcon from '../components/icons/game_konsole.vue'
import AlertMessage from './alert_message.vue';

export default {
    setup() {
        return {
            RouterLink
        }
    },
    components: {
        BackButton,
        PendidikanIcon,
        BeritaIcon,
        GameIcon,
        AlertMessage
    },
    data() {
        return {
            judulBuku: '',
            kodeBuku: '',
            kategori: '',
            tahunRilis: '',
            deskripsi: '',
            kategoriInt: '',
            someThingHappend: false,
            message: '',
            isWrongClass: 'bg-red-700 shadow-lg shadow-red-600',
        }
    },
    methods: {
        async createBook() {
            this.convertKategoriToInt()
            if (
                (this.judulBuku !== '' && this.judulBuku.length > 5) &&
                (this.kodeBuku !== '' && this.kodeBuku.length == 5) &&
                (this.kategori !== '') &&
                (this.kategoriInt !== '') &&
                (this.deskripsi !== '')
            )  {
                try {
                    const response = await axios.post('http://localhost:8123/api/v1/buku/create', {
                        judulBuku: this.judulBuku,
                        kodeBuku: this.kodeBuku,
                        kategori: this.kategoriInt,
                        tahunRilis: this.tahunRilis,
                        deskripsi: this.deskripsi
                    });
                    this.someThingHappend = true
                    this.message = "Succes created"
                    this.isWrongClass = "bg-green-700 shadow-lg shadow-green-600"
                    setTimeout(() => {
                        this.resetContent()
                        this.someThingHappend = false
                        this.isWrongClass = "bg-red-700 shadow-lg shadow-red-600"
                    }, 4000);
                    console.log(response.data);
                } catch (error) {
                    console.error(error.response.data);
                    if (error.response.status == 400) {
                        this.someThingHappend = true;
                        this.message = error.response.data.message
                        setTimeout(() => {
                            this.someThingHappend = false;
                        }, 4000)
                    }
                }
            } else {
                this.someThingHappend = true
                this.message = "Your input is wrong!!"
                setTimeout(() => {
                    this.someThingHappend = false;
                }, 4000)
            }
        },
        convertKategoriToInt() {
            switch (this.kategori) {
                case "pendidikan":
                    this.kategoriInt = 2
                    break;
                case "hiburan":
                    this.kategoriInt = 0
                    break
                case "berita":
                    this.kategoriInt = 1
                    break
                default:
                    this.kategoriInt = 2
                    break;
            }
        },
        resetContent() {
            this.judulBuku = ''
            this.kodeBuku = ''
            this.kategori = ''
            this.tahunRilis = ''
            this.deskripsi = ''
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

.input-book {
    width: 80%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    margin: 10px;
    padding: 8px;
    background: #ebebeb;
    border-radius: 10px;
}

.input-book input,
select,
textarea {
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

.input-book:nth-child(1) {
    animation: fadeIn 1s ease-in forwards;
}

.input-book:nth-child(2) {
    animation: fadeIn 2s ease-in forwards;
}

.input-book:nth-child(3) {
    animation: fadeIn 3s ease-in forwards;
}

.input-book:nth-child(4) {
    animation: fadeIn 4s ease-in forwards;
}

.input-book:nth-child(5) {
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
    from {
        opacity: 0;
        transform: scale(.5);
    }

    to {
        opacity: 1;
        transform: scale(1);
    }
}
</style>