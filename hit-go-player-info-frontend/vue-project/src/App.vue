<script setup>
  import AsideComponent from './components/Aside.vue'
  import MainComponent from './components/Main.vue'
  import FooterComponent from './components/Footer.vue'
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header style="padding: 0; height: 10vh">
        <div id="header">
          <div class="project-title" id="project-title" size="large">HIT棋手信息查询系统</div>
        </div>
      </el-header>
      <el-container>
        <el-aside style="width: 200px; padding: 0;">
          <AsideComponent />
        </el-aside>
        <el-container id="main-and-footer">
            <MainComponent />
            <FooterComponent />
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>
  
  /* div{
    text-align:center;
  } */

  #header{
    padding: 0;
    /* margin-left: -20px; */
    display: flex;
    justify-content: center;
    align-items: center;
    height: 10vh;
    width: 100vw;
    background-color: #D4D7DE;
  }

  #project-title{
    /* line-height: 30px; */
    height: 100%;
    width: 300px;
    color: #303133;
    /* border-radius: 10px; */
    background-color: #FAFAFA;
    font-weight: bold;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: x-large;
  }

  el-main{
    align-items: center;
  }

  #main-and-footer{
    flex-direction: column;
    justify-content: space-between;
    display: flex;
    
  }
</style>