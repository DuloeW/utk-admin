<template>
    <div class="main w-10/12 h-10/12 bg-slate-100 rounded-xl overflow-y-scroll relative">
        <RouterLink to="/">
            <BackButton class="absolute top-0 left-0 text-base p-2 text-black m-2" />
        </RouterLink>
        <div class="p-2 w-fit flex justify-center relative mx-auto">
            <input type="search" name="" id="" size="50"
                class="text-xs p-4 tracking-[1px] rounded-sm bg-slate-500 border-none outline-none text-white">
            <button class="h-3/6 bg-blue-500 rounded-sm text-white absolute right-3 top-3 w-[15%] mt-1 mr-1">cari</button>
        </div>
        <table class="w-full">
            <tr>
                <th>No</th>
                <th>Judul Buku</th>
                <th>Kode Buku</th>
                <th>Kategori</th>
                <th class="w-1/12">Delete</th>
            </tr>
            <tr v-for="(data, index) in datas" :key="data.id" class="text-center">
                <td>{{ index + 1 }}</td>
                <td>{{ data.judul }}</td>
                <td>{{ data.kode }}</td>
                <td>{{ data.kategori }}</td>
                <td><button @click="isDelete(data.id)"
                        class="px-2 py-1 bg-red-700 text-white tracking-[2px] text-sm rounded-md">Delete</button></td>
            </tr>
        </table>
    </div>
</template>
<script>
import { RouterLink } from 'vue-router';
import BackButton from './icons/back_button.vue'
import TrashIcon from '../components/icons/trash_icon.vue'
export default {
    setup() {
        return {
            RouterLink
        }
    },
    components: {
        BackButton,
        TrashIcon
    },
    data() {
        return {
            no: 1,
            isClick: false,
            datas: [
                {
                    id: 138293820321,
                    judul: "Memasaka Yanin",
                    kode: "2902",
                    kategori: "Hiburan",
                    tahun_rilis: "12/09/2006",
                    deskripsi: "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Doloremque et molestiae, nisi fugit veniam iste voluptatem cumque, nam debitis non repudiandae nobis ipsa rerum dolore explicabo laborum tenetur perferendis magni quae nihil earum doloribus! Sed non rem accusamus vitae veritatis, explicabo provident laborum accusantium corporis saepe voluptate tenetur commodi ad, fuga nesciunt cupiditate impedit numquam nisi repudiandae odit quam odio? Iste, eos aliquid, temporibus fuga quaerat sed perspiciatis quam iusto rem dicta tenetur quod ullam qui, voluptatibus nam dolores reiciendis dolore distinctio numquam cumque? Recusandae amet earum minus blanditiis autem rerum, ullam reprehenderit commodi, minima quam tempore reiciendis! Dolores, neque"
                },
                {
                    id: 2382938202302,
                    judul: "Makan Nasi",
                    kode: "2902",
                    kategori: "Berita",
                    tahun_rilis: "12/09/2006",
                    deskripsi: "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Doloremque et molestiae, nisi fugit veniam iste voluptatem cumque, nam debitis non repudiandae nobis ipsa rerum dolore explicabo laborum tenetur perferendis magni quae nihil earum doloribus! Sed non rem accusamus vitae veritatis, explicabo provident laborum accusantium corporis saepe voluptate tenetur commodi ad, fuga nesciunt cupiditate impedit numquam nisi repudiandae odit quam odio? Iste, eos aliquid, temporibus fuga quaerat sed perspiciatis quam iusto rem dicta tenetur quod ullam qui, voluptatibus nam dolores reiciendis dolore distinctio numquam cumque? Recusandae amet earum minus blanditiis autem rerum, ullam reprehenderit commodi, minima quam tempore reiciendis! Dolores, neque"
                },
                {
                    id: 3212192898,
                    judul: "Belajar Vue Js",
                    kode: "2902",
                    kategori: "Pendidikan",
                    tahun_rilis: "12/09/2006",
                    deskripsi: "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Doloremque et molestiae, nisi fugit veniam iste voluptatem cumque, nam debitis non repudiandae nobis ipsa rerum dolore explicabo laborum tenetur perferendis magni quae nihil earum doloribus! Sed non rem accusamus vitae veritatis, explicabo provident laborum accusantium corporis saepe voluptate tenetur commodi ad, fuga nesciunt cupiditate impedit numquam nisi repudiandae odit quam odio? Iste, eos aliquid, temporibus fuga quaerat sed perspiciatis quam iusto rem dicta tenetur quod ullam qui, voluptatibus nam dolores reiciendis dolore distinctio numquam cumque? Recusandae amet earum minus blanditiis autem rerum, ullam reprehenderit commodi, minima quam tempore reiciendis! Dolores, neque"
                }
            ]
        }
    },
    methods: {
        isDelete(index) {
            this.isClick = !this.isClick;
            const indexToRemove = this.datas.findIndex(element => element.id === index);
            if (indexToRemove !== -1) {
                this.datas.splice(indexToRemove, 1);
            }
        }
    }
}
</script>
<style scoped>
th {
    position: sticky;
    top: 0;
    background: #F1F5F9;
    padding: 10px;
}

td {
    padding: 20px;
    background: #eeeeee;
}

tr {
    border: 10px solid #F1F5F9;
}

.main {
    animation: naik 1s ease-in forwards;
}

@keyframes naik {
    from {
        opacity: 0;
    }

    to {
        opacity: 1;
    }
}
</style>

