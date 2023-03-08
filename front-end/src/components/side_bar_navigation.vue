<template>
    <div class="bg-white shadow-2xl max-w-sm w-72 h-screen flex flex-col items-center p-5 relative gap-4">
        <div class="w-full h-20 flex justify-around items-center z-[1]">
            <img src="../assets/Picture1.png" alt="logo smk 2 tabanan" width="60" height="60">
            <h1 class="text-xl text-center font-semibold tracking-wider">Perpustakaan Digital</h1>
        </div>
        <div class="absolute top-0 right-0 w-36 h-24 bg-cyan-300 rounded-bl-[90px]"></div>

        <!--Bagian icon sidebar -->
        <div class="w-full h-full flex flex-col border-t-4">
            <div
                class="w-full h-fit bg-neutral-200 border-l-8 border-blue-600 mt-7 flex gap-3 p-4 rounded-tr-xl rounded-br-xl cursor-pointer">
                <font-awesome-icon icon="fa-solid fa-house" class="text-2xl" />
                <h3>Halaman utama</h3>
            </div>
            <div @click="bukuClicked"
                class="w-full h-fit border-l-8 border-white mt-7 flex gap-3 p-4 rounded-tr-xl cursor-pointer">
                <font-awesome-icon icon="fa-solid fa-book" class="text-2xl" />
                <h3>Buku</h3>
                <font-awesome-icon icon="fa-solid fa-chevron-down" :class="arrowBookUpOrDown" class="ml-auto" />
            </div>
            <div v-if="isBukuClicked" class="flex flex-col">
                <RouterLink to="/add-book">
                    <div class="w-52 h-fit mx-auto flex gap-3 p-4 cursor-pointer">
                        <font-awesome-icon icon="fa-solid fa-file-circle-plus" />
                        <h4>Tambah Buku</h4>
                    </div>
                </RouterLink>
                <RouterLink to="/update-book">
                    <div class="w-52 h-fit mx-auto flex gap-3 p-4 rounded-tr-xl cursor-pointer">
                        <font-awesome-icon icon="fa-solid fa-pen-to-square" />
                        <h4>Ubah Buku</h4>
                    </div>
                </RouterLink>
                <RouterLink to="/delete-book">
                    <div class="w-52 h-fit mx-auto flex gap-3 p-4 rounded-tr-xl cursor-pointer">
                        <font-awesome-icon icon="fa-solid fa-trash-can" />
                        <h4>Hapus Buku</h4>
                    </div>
                </RouterLink>
            </div>
            <div @click="peminjamClicked"
                class="w-full h-fit border-l-8 border-white mt-7 flex gap-3 p-4 rounded-tr-xl cursor-pointer">
                <font-awesome-icon icon="fa-solid fa-users" class="text-2xl" />
                <h3>Peminjam</h3>
                <font-awesome-icon icon="fa-solid fa-chevron-down" :class="arrowPeminjamUpOrDown" class="ml-auto" />
            </div>
            <div v-if="isPeminjamClicked" class="flex flex-col">
                <RouterLink to="/add-peminjam">
                    <div class="w-52 h-fit mx-auto flex gap-3 p-4 cursor-pointer">
                        <font-awesome-icon icon="fa-solid fa-user-plus" />
                        <h4>Tambah Peminjam</h4>
                    </div>
                </RouterLink>
                <RouterLink to="/delete-peminjam">
                    <div class="w-52 h-fit mx-auto flex gap-3 p-4 rounded-tr-xl cursor-pointer">
                        <font-awesome-icon icon="fa-solid fa-user-minus" />
                        <h4>Hapus Peminjam</h4>
                    </div>
                </RouterLink>
            </div>
            <RouterLink to="/admin-profile">
                <div
                    class="w-full h-fit border-l-8 border-white mt-7 flex gap-3 p-4 rounded-tr-xl rounded-br-xl cursor-pointer">
                    <font-awesome-icon icon="fa-solid fa-user" class="text-2xl" />
                    <h3>Admin Profile</h3>
                </div>
            </RouterLink>
        </div>
    </div>
</template>
<script>
import { RouterLink } from 'vue-router';

export default {
    data() {
        return {
            isBukuClicked: false,
            isPeminjamClicked: false,
            arrowBookUpOrDown: 'arrow-book-down',
            arrowPeminjamUpOrDown: 'arrow-peminjam-down'
        }
    },
    components: {
        RouterLink
    },
    methods: {
        bukuClicked() {
            this.isBukuClicked = !this.isBukuClicked
            this.isPeminjamClicked = false
            if (this.arrowPeminjamUpOrDown != 'arrow-peminjam-down') {
                this.arrowPeminjamUpOrDown = 'arrow-peminjam-down'
            }

            if (this.arrowBookUpOrDown != 'arrow-book-down') {
                this.arrowBookUpOrDown = 'arrow-book-down'
            } else {
                this.arrowBookUpOrDown = 'arrow-book-up'
            }
        },
        peminjamClicked() {
            this.isPeminjamClicked = !this.isPeminjamClicked
            this.isBukuClicked = false
            if (this.arrowBookUpOrDown != 'arrow-book-down') {
                this.arrowBookUpOrDown = 'arrow-book-down'
            }

            if (this.arrowPeminjamUpOrDown != 'arrow-peminjam-down') {
                this.arrowPeminjamUpOrDown = 'arrow-peminjam-down'
            } else {
                this.arrowPeminjamUpOrDown = 'arrow-peminjam-up'
            }
        }

    }
}
</script>
<style scoped>
.arrow-book-up {
    animation: up .1s ease-in-out forwards;
}

.arrow-book-down {
    animation: down .2s ease-in-out forwards;
}

.arrow-peminjam-up {
    animation: up .1s ease-in-out forwards;
}

.arrow-peminjam-down {
    animation: down .2s ease-in-out forwards;
}

@keyframes up {
    from {
        transform: rotate(0deg);
    }

    to {
        transform: rotate(180deg);
    }
}

@keyframes down {
    from {
        transform: rotate(180deg);
    }

    to {
        transform: rotate(0deg);
    }
}
</style>