<template>
    <div class="main w-10/12 h-10/12 bg-slate-100 rounded-xl overflow-y-scroll relative">
        <RouterLink to="/">
            <BackButton class="absolute top-0 left-0 text-base p-2 text-black m-2"/>
        </RouterLink>
        <div class="">
            <div class="p-2 w-fit flex justify-center relative mx-auto">
                <input type="search" name="" size="50" id="" class="text-xs p-4 tracking-[1px] rounded-sm bg-slate-500 border-none outline-none text-white">
                <button class="h-3/6 bg-blue-500 rounded-sm text-white absolute right-3 top-3 w-[15%] mt-1 mr-1">cari</button>
            </div>
        </div>
        <table class="w-full">
            <tr>
                <th>No</th>
                <th>Judul Buku</th>
                <th>Kode Buku</th>
                <th>Kategori</th>
                <th class="w-1/12">Update</th>
            </tr>
            <tr class="text-center">
                <td>1</td>
                <td>Memasak Nasi</td>
                <td>2812</td>
                <td>Pendidikan</td>
                <td>
                    <RouterLink to="/update-book/1">
                        <button class="px-2 py-1 bg-green-700 text-white tracking-[2px] text-sm rounded-md">update</button>
                    </RouterLink>
                </td>
            </tr>
        </table>
    </div>
</template>
<script>
import { RouterLink } from 'vue-router';
import BackButton from './icons/back_button.vue'
export default {
    setup() {
        return {
            RouterLink
        }
    },
    components: {
        BackButton
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