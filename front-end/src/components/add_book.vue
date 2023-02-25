<template>
    <div class="w-10/12 h-10/12 flex justify-center items-center relative">
        <RouterLink to="/">
            <BackButton class="absolute top-0 left-0 text-base p-2 text-white m-2" />
        </RouterLink>
        <form class="w-full h-full p-4 overflow-hidden flex flex-col justify-center items-center">
            <div class="input-book">
                <label for="">Judul Buku</label>
                <input type="text" required>
            </div>
            <div class="input-book">
                <label for="">Kode Buku</label>
                <input type="text" maxlength="4" minlength="4" required>
            </div>
            <div class="input-book">
                <label for="">Kategori</label>
                <select name="" id="">
                    <option value="pendidikan">Pendidikan</option>
                    <option value="hiburan" selected>Hiburan</option>
                    <option value="berita">Berita</option>
                </select>
            </div>
            <div class="input-book">
                <label for="">Tahun Rilis</label>
                <input type="date" required>
            </div>
            <div class="input-book">
                <label for="">Deskripsi</label>
                <textarea name="" id="" cols="2" rows="3" required></textarea>
            </div>
            <div class="text-white mt-3">
                <button type="submit" class="btn-kiri px-2 bg-green-700 rounded">Kirim</button>
                <input type="reset" value="hapus" class="btn-kanan px-2 bg-red-700 ml-2 rounded">
            </div>
        </form>
    </div>
</template>

<script>
import { RouterLink } from 'vue-router';
import BackButton from '../components/icons/back_button.vue'
import PendidikanIcon from '../components/icons/student.vue'
import BeritaIcon from '../components/icons/news.vue'
import GameIcon from '../components/icons/game_konsole.vue'

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
        GameIcon
    },
    data() {
        return {

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