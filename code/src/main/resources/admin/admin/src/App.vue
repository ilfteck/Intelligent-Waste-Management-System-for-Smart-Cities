<template>
  <div id="app" class="">
    <router-view></router-view>
  </div>
</template>

<script>
import i18ntranslate from 'i18n-jsautotranslate'
export default {
  name: "app",
  mounted() {
    setTimeout(()=>{
      i18ntranslate.changeLanguage('english')
      i18ntranslate.listener.start();
      i18ntranslate.setUseVersion2();
      i18ntranslate.execute();//进行翻译
    },500)
  }
};
</script>

<style lang="scss">
@import "utils/theme.scss";/*引入全局颜色*/
*{
  padding: 0;
  margin:0;
}
html,body{
  width: 100%;
  height: 100%;
}
#app{
  height:100%;
}
body {
  padding: 0;
  margin: 0;
  
}
</style>
