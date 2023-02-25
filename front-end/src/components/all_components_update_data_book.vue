<script setup>
import { RouterLink } from 'vue-router';
import BoxDataAfter from '../components/box_data_book_will_update.vue'
import BoxDataBefore from '../components/box_data_book.vue'
import BackButton from '../components/icons/back_button.vue'
</script>
<template>
    <div class="h-full w-full flex justify-around items-center relative gap-2">
        <RouterLink to="/update-book" class="absolute top-0 left-0">
            <BackButton class="text-white" />
        </RouterLink>
        <BoxDataBefore />
        <BoxDataAfter />
    </div>
</template>