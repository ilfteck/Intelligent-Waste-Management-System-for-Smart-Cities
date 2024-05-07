import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import transport from '@/views/modules/transport/list'
    import dictionary from '@/views/modules/dictionary/list'
    import announcement from '@/views/modules/announcement/list'
    import recycle from '@/views/modules/recycle/list'
    import recyclereserve from '@/views/modules/recyclereserve/list'
    import member from '@/views/modules/member/list'
    import dictionarytransport from '@/views/modules/dictionarytransport/list'
    import dictionaryannouncement from '@/views/modules/dictionaryannouncement/list'
    import dictionaryrecycle from '@/views/modules/dictionaryrecycle/list'
    import dictionaryrecyclereserveYesno from '@/views/modules/dictionaryrecyclereserveYesno/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import shenqing from '@/views/modules/recyclereserve/add-or-update'
    import yunshu from '@/views/modules/transport/add-or-update'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionarytransport',
        name: '运输类型',
        component: dictionarytransport
    }
    ,{
        path: '/dictionaryannouncement',
        name: '公告类型',
        component: dictionaryannouncement
    }
    ,{
        path: '/dictionaryrecycle',
        name: '垃圾回收类型',
        component: dictionaryrecycle
    }

        ,{
            path: '/shenqing',
            name: '运输申请',
            component: shenqing
        },
        {
            path: '/yunshu',
            name: '运输',
            component: yunshu
        }
    ,{
        path: '/dictionaryrecyclereserveYesno',
        name: '申请状态',
        component: dictionaryrecyclereserveYesno
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }


    ,{
        path: '/transport',
        name: '运输',
        component: transport
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/announcement',
        name: '公告',
        component: announcement
      }
    ,{
        path: '/recycle',
        name: '垃圾回收',
        component: recycle
      }
    ,{
        path: '/recyclereserve',
        name: '垃圾出库申请',
        component: recyclereserve
      }
    ,{
        path: '/member',
        name: '用户',
        component: member
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
