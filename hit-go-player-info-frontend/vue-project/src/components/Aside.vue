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
            
            adminCreateUi(){
                this.store.type = 'adminCreate';
            },

            adminLoginUi(){
                this.store.type = 'adminLogin'
            },

            addPlayerUi(){
                this.store.type = 'addPlayer'
            },

            queryPlayerUi(){
                this.store.type = 'queryPlayer'
            },

            playerMatchUi(){
                this.store.type = 'playerMatch'
            },

            updatePlayerUi(){
                this.store.type = 'updatePlayer'
            },

            deletePlayerUi(){
                this.store.type = 'deletePlayer'
            }
        }
    }

</script>

<template>
    <div id="aside">
        <div class="mx-1" type="primary">HIT</div>
        <div id="inner">
            <el-button class="button" type="info" plain @click="adminCreateUi">管理员注册</el-button>
            <el-button class="button" type="info" plain @click="adminLoginUi">管理员登录</el-button>
            <el-button class="button" type="info" plain @click="addPlayerUi">添加棋手信息</el-button>
            <el-button class="button" type="info" plain @click="queryPlayerUi">查询棋手信息</el-button>
            <el-button class="button" type="info" plain @click="playerMatchUi">棋手比赛成绩</el-button>
            <el-button class="button" type="info" plain @click="updatePlayerUi" v-show="this.store.isAdmin === true">修改棋手信息</el-button>
            <el-button class="button" type="info" plain @click="deletePlayerUi" v-show="this.store.isAdmin === true">删除棋手信息</el-button>
        </div>
    </div>
</template>

<style scoped>
    
    #aside{
        display: flex;
        flex-direction: column;
        width: 200px;
        height: 85vh;
        background-color: #FAFCFF;
        margin: 0;
        /* justify-content: ; */
    }

    .button{
        display: flex;
        justify-content: center;
        margin-top: 10px;
        margin-bottom: 10px;
        margin-left: 30px !important;
        margin-right: 30px !important;
        border-radius: 5px;
        width: 120px;
        height: 30px;
        color:black;
        /* background-color: ; */
    }

    .mx-1{
        margin-top: 0;
        height: 40px;
        width: 100%;
        background-color: #909399;
        line-height: 40px;
        color: black;
        font-weight: normal;
    }

    #inner{
        display: flex;
        flex-direction: column;
        justify-content: space-evenly;
        align-items: center;
        height: 500px;
        width: 100%;
        background-color: #FAFCFF;
    }

    div{
        text-align: center;
    }
</style>