<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
<!--                <el-col :span="12"  v-if="sessionTable !='recycle'">-->
<!--                    <el-form-item class="select" v-if="type!='info'"  label="垃圾回收" prop="recycleId">-->
<!--                        <el-select v-model="ruleForm.recycleId" :disabled="ro.recycleId" filterable placeholder="请选择垃圾回收" @change="recycleChange">-->
<!--                            <el-option-->
<!--                                    v-for="(item,index) in recycleOptions"-->
<!--                                    v-bind:key="item.id"-->
<!--                                    :label="item.recycleName"-->
<!--                                    :value="item.id">-->
<!--                            </el-option>-->
<!--                        </el-select>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->

                <el-col :span="12"  v-if="sessionTable !='recycle' ">
                    <el-form-item class="input" v-if="type!='info'"  label="垃圾回收名称" prop="recycleName">
                        <el-input v-model="recycleForm.recycleName"
                                  placeholder="垃圾回收名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="垃圾回收名称" prop="recycleName">
                            <el-input v-model="ruleForm.recycleName"
                                      placeholder="垃圾回收名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='recycle' ">
                    <el-form-item class="input" v-if="type!='info'"  label="垃圾回收编号" prop="recycleUuidNumber">
                        <el-input v-model="recycleForm.recycleUuidNumber"
                                  placeholder="垃圾回收编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="垃圾回收编号" prop="recycleUuidNumber">
                            <el-input v-model="ruleForm.recycleUuidNumber"
                                      placeholder="垃圾回收编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='recycle' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.recyclePhoto" label="垃圾回收照片" prop="recyclePhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (recycleForm.recyclePhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.recyclePhoto" label="垃圾回收照片" prop="recyclePhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.recyclePhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='recycle' ">
                    <el-form-item class="input" v-if="type!='info'"  label="垃圾回收地点" prop="recycleAddress">
                        <el-input v-model="recycleForm.recycleAddress"
                                  placeholder="垃圾回收地点" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="垃圾回收地点" prop="recycleAddress">
                            <el-input v-model="ruleForm.recycleAddress"
                                      placeholder="垃圾回收地点" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='recycle' ">
                    <el-form-item class="input" v-if="type!='info'"  label="垃圾回收类型" prop="recycleValue">
                        <el-input v-model="recycleForm.recycleValue"
                                  placeholder="垃圾回收类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="垃圾回收类型" prop="recycleValue">
                            <el-input v-model="ruleForm.recycleValue"
                                      placeholder="垃圾回收类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='recycle' ">
                    <el-form-item class="input" v-if="type!='info'"  label="垃圾回收库存" prop="recycleKucunNumber">
                        <el-input v-model="recycleForm.recycleKucunNumber"
                                  placeholder="垃圾回收库存" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="垃圾回收库存" prop="recycleKucunNumber">
                            <el-input v-model="ruleForm.recycleKucunNumber"
                                      placeholder="垃圾回收库存" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='recycle' ">
                    <el-form-item class="input" v-if="type!='info'"  label="入库时间" prop="recycleTime">
                        <el-input v-model="recycleForm.recycleTime"
                                  placeholder="入库时间" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="入库时间" prop="recycleTime">
                            <el-input v-model="ruleForm.recycleTime"
                                      placeholder="入库时间" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='member'">
                    <el-form-item class="select" v-if="type!='info'"  label="用户" prop="memberId">
                        <el-select v-model="ruleForm.memberId" :disabled="ro.memberId" filterable placeholder="请选择用户" @change="memberChange">
                            <el-option
                                    v-for="(item,index) in memberOptions"
                                    v-bind:key="item.id"
                                    :label="item.memberName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='member' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="memberName">
                        <el-input v-model="memberForm.memberName"
                                  placeholder="用户姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户姓名" prop="memberName">
                            <el-input v-model="ruleForm.memberName"
                                      placeholder="用户姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='member' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户手机号" prop="memberPhone">
                        <el-input v-model="memberForm.memberPhone"
                                  placeholder="用户手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户手机号" prop="memberPhone">
                            <el-input v-model="ruleForm.memberPhone"
                                      placeholder="用户手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='member' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户身份证号" prop="memberIdNumber">
                        <el-input v-model="memberForm.memberIdNumber"
                                  placeholder="用户身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户身份证号" prop="memberIdNumber">
                            <el-input v-model="ruleForm.memberIdNumber"
                                      placeholder="用户身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='member' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.memberPhoto" label="用户头像" prop="memberPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (memberForm.memberPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.memberPhoto" label="用户头像" prop="memberPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.memberPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='member' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户邮箱" prop="memberEmail">
                        <el-input v-model="memberForm.memberEmail"
                                  placeholder="用户邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户邮箱" prop="memberEmail">
                            <el-input v-model="ruleForm.memberEmail"
                                      placeholder="用户邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报名编号" prop="recyclereserveUuidNumber">
                       <el-input v-model="ruleForm.recyclereserveUuidNumber"
                                 placeholder="报名编号" clearable  :readonly="ro.recyclereserveUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="报名编号" prop="recyclereserveUuidNumber">
                           <el-input v-model="ruleForm.recyclereserveUuidNumber"
                                     placeholder="报名编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            <input id="recycleId" name="recycleId" type="hidden">
            <input id="memberId" name="memberId" type="hidden">
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="报名理由" prop="recyclereserveText">
                        <el-input type="textarea"  :readonly="ro.recyclereserveText" v-model="ruleForm.recyclereserveText" placeholder="报名理由"></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.recyclereserveText" label="报名理由" prop="recyclereserveText">
                            <span v-html="ruleForm.recyclereserveText"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'"  class="input" label="出库时间" prop="recycletransportTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.recycletransportTime"
                                type="datetime"
                                placeholder="出库时间"
                                :disabled="ro.recycletransportTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.recycletransportTime" label="出库时间" prop="recycletransportTime">
                            <span v-html="ruleForm.recycletransportTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.recyclereserveYesnoTypes" label="申请状态" prop="recyclereserveYesnoTypes">
                        <el-input v-model="ruleForm.recyclereserveYesnoValue" placeholder="申请状态" readonly></el-input>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.recyclereserveYesnoText" label="审核回复" prop="recyclereserveYesnoText">
                        <span v-html="ruleForm.recyclereserveYesnoText"></span>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.recyclereserveShenheTime" label="审核时间" prop="recyclereserveShenheTime">
                        <span v-html="ruleForm.recyclereserveShenheTime"></span>
                    </el-form-item>
                </div>
            </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                recycleForm: {},
                memberForm: {},
                ro:{
                    recyclereserveUuidNumber: false,
                    recycleId: false,
                    memberId: false,
                    recyclereserveText: false,
                    recycletransportTime: false,
                    recyclereserveYesnoTypes: false,
                    recyclereserveYesnoText: false,
                    recyclereserveShenheTime: false,
                    insertTime: false,
                },
                ruleForm: {
                    recyclereserveUuidNumber: new Date().getTime(),
                    recycleId: '',
                    memberId: '',
                    recyclereserveText: '',
                    recycletransportTime: '',
                    recyclereserveYesnoTypes: '',
                    recyclereserveYesnoText: '',
                    recyclereserveShenheTime: '',
                    insertTime: '',
                },
                recyclereserveYesnoTypesOptions : [],
                recycleOptions : [],
                memberOptions : [],
                rules: {
                   recyclereserveUuidNumber: [
                              { required: true, message: '报名编号不能为空', trigger: 'blur' },
                          ],
                   recycleId: [
                              { required: true, message: '垃圾回收不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   memberId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   recyclereserveText: [
                              { required: true, message: '报名理由不能为空', trigger: 'blur' },
                          ],
                   recycletransportTime: [
                              { required: true, message: '出库时间不能为空', trigger: 'blur' },
                          ],
                   recyclereserveYesnoTypes: [
                              { required: true, message: '申请状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   recyclereserveYesnoText: [
                              { required: true, message: '审核回复不能为空', trigger: 'blur' },
                          ],
                   recyclereserveShenheTime: [
                              { required: true, message: '审核时间不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '活动报名时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");

          this.$route.query.id
          console.log(this.$route.query.id, 88888)
          this.recycleChange(this.$route.query.id)

            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=recycle_reserve_yesno_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.recyclereserveYesnoTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `recycle/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.recycleOptions = data.data.list;
            }
         });
         this.$http({
             url: `member/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.memberOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            recycleChange(id){
                this.$http({
                    url: `recycle/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.recycleForm = data.data;
                    }
                });
            },
            memberChange(id){
                this.$http({
                    url: `member/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.memberForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `recyclereserve/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.recycleChange(data.data.recycleId)
                        _this.memberChange(data.data.memberId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                  this.ruleForm.recycleId = this.$route.query.id
                    if (valid) {
                        this.$http({
                            url:`recyclereserve/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                      this.$router.push(
                                          {
                                            path: '/recyclereserve',
                                            query: {
                                            }
                                          }
                                      )
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
              this.$router.push(
                  {
                    path: '/recyclereserve',
                    query: {
                    }
                  }
              )
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

