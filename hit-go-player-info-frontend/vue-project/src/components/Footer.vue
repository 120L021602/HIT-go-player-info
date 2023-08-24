<script>
    import axios from 'axios'
    import {useStore} from '../stores/store.js'

    export default{
        setup(){
            const store = useStore();
            return {store};

        },

        mounted(){

        },

        data(){
            return{

            }
        },

        methods:{

        }
    }

</script>

<template>
    <div id="footer">
        <el-text id="comment" size="large" v-show="this.store.success === true && this.store.type === 'playerInfo'">评价：{{ this.store.comment }}</el-text>
    </div>
</template>

<style scoped>
    
    #footer{
        height: 50px;
        width: calc(100vw)-180px;
        background-color: #F0F2F5;
        flex-grow: 1;
    }

    #comment{
        font-size: larger;
    }
</style>