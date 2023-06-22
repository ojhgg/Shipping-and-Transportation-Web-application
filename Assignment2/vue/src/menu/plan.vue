<template>
    <div class="whole_container">
        <div class="inputData">
            <el-tabs v-model="defaultTab" @tab-click="handleClick" >
                <el-tab-pane label="创建订单" name="first">
                    <el-form :inline="true" :model="createOrder" class="mag" ref="createOrder"  >
                        <el-form-item label="备注:" prop="id">
                            <el-input v-model="createOrder.deliveryinstructions" placeholder="ID"></el-input>
                        </el-form-item>
                        <el-form-item label="包裹目的地：" prop="place">
                            <el-input v-model="createOrder.shipto" placeholder="目的地"></el-input>
                        </el-form-item>
                        <el-form-item label="运输类型:" prop="id">
                            <el-input v-model="createOrder.type" placeholder="type"></el-input>
                        </el-form-item>
                        <el-form-item label="包裹来源地：" prop="place">
                            <el-input v-model="createOrder.shipfrom" placeholder="来源地"></el-input>
                        </el-form-item>
                        <el-form-item label="包裹位置：" prop="place">
                            <el-input v-model="createOrder.returnto" placeholder="当前位置"></el-input>
                            <el-form :inline="true" :model="createOrder.parcels" class="mag" >
                                <el-form-item label="装箱类型:" prop="id">
                                    <el-input v-model="createOrder.parcels.boxtype" placeholder="boxtype"></el-input>
                                </el-form-item>
                                <el-form-item label="描述：" prop="place">
                                    <el-input v-model="createOrder.parcels.description" placeholder="描述"></el-input>
                                </el-form-item>
                                <el-form-item label="重量:" prop="id">
                                    <el-input v-model="createOrder.parcels.weight" placeholder="type"></el-input>
                                </el-form-item>
                                <el-form-item label="包裹ID：" prop="place">
                                    <el-input v-model="createOrder.parcels.parcelsid" placeholder="包裹号码"></el-input>
                                </el-form-item>
                                <el-form-item label="数量:" prop="id">
                                    <el-input v-model="createOrder.parcels.quantity" placeholder="数量"></el-input>
                                </el-form-item>
                            </el-form>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary"  @click="submitForm('createOrder')">创建订单</el-button>
                        </el-form-item>
                    </el-form>

                </el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>

<script>

import user from "@/api/user";

export default{
    computed: {

        parcels() {
            return this.parcels
        },
       createOrder() {
           return this.createOrder
        }
    },
    data(){

        return{
            loading: false,//加载效果
            defaultTab:'first',
            // eslint-disable-next-line vue/no-dupe-keys
            createOrder:{
                deliveryinstructions: "",
                returnto: "",
                shipfrom: "",
                shipto: "",
                type: "",
                parcels: {
                    boxtype: "",
                    description: "",
                    weight: "",
                    parcelsid: "",
                    quantity: ""
                }
            },

        }
    },

    methods: {
        submitForm (formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.loading = true
                    user.createorder(this.createOrder).then(_ => {
                        if (_) {
                            this.$message({
                                message: '创建订单成功',
                                type: 'success'
                            })
                        }
                        else {
                            this.$message({
                                message: '订单创建失败',
                                type: 'error'
                            })
                        }
                    }).finally(_ => {
                        this.loading = false
                    })
                }
            })
        },

        }

}
</script>

<style lang="less" scoped>
#stock{
  border: 1px solid rgb(61, 94, 155);
}


.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
.can {
  background-color: #eef3fb;
}
</style>