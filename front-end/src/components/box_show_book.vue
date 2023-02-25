<template>
    <div class="main w-full h-28 p-2 rounded-md text-white bg-slate-600 flex justify-between">
        <MdBookIcon class="text-8xl"/>
        <div class="w-full h-full flex flex-col justify-between p-2">
            <h1 class="text-xl font-serif tracking-widest">Buku</h1>
            <p class="text-[12px]">5 unit</p>
            <RouterLink to="/detail-books" class="self-end">
                <a href="" class="self-end text-xs tracking-[2px] px-3 py-1 bg-green-600 rounded-sm">detail..</a>
            </RouterLink>
        </div>
    </div>
</template>
<script>
import { RouterLink } from 'vue-router';
import MdBookIcon from 'vue-ionicons/dist/md-book.vue'
export default {
    setup() {
        return {
            RouterLink
        }
    },
    components: {
        MdBookIcon
    }
}
</script>

<style scoped>

.main {
    animation: kebawah 1s ease-in forwards;
}

@keyframes kebawah {
    from {
        transform: translateY(-100%);
        opacity: 0;
    }
    to {
        transform: translateY(0);
        opacity: 1;
    }
}
</style>