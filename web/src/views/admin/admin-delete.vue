<template>
  <a-layout>
    <a-layout-content
      :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <p>
        <a-form layout="inline" :model="param">
          <a-form-item>
            <a-button type="primary" @click="handleQuery({page: 1, size: pagination.pageSize})">
              查询
            </a-button>
          </a-form-item>
        </a-form>
      </p>

      <a-table
          :columns="columns"
          :row-key="record => record.id"
          :data-source="users"
          :pagination="pagination"
          :loading="loading"
          @change="handleTableChange"
      >
      </a-table>
    </a-layout-content>
  </a-layout>

</template>

<script lang="ts">
  import { defineComponent, onMounted, ref } from 'vue';
  import axios from 'axios';
  import { message } from 'ant-design-vue';
  import {Tool} from "@/util/tool";

  declare let hexMd5: any;
  declare let KEY: any;

  export default defineComponent({
    name: 'AdminTanrui',
    setup() {
      const param = ref();
      param.value = {};
      //获得当前用户
      const users = ref();
      //设置分页参数，当前页是1，容纳10条记录
      const pagination = ref({
        current: 1,
        pageSize: 10,
        total: 0
      });
      const loading = ref(false);

      //设置参数
      const columns = [
        {
          title: '用户ID',
          dataIndex: 'userId'
        },
        {
          title: '文档ID',
          dataIndex: 'wordId'
        },
        {
          title: '用户名',
          dataIndex: 'username'
        },
        {
          title: '文档名',
          dataIndex: 'wordname'
        },
      ];

      /**
       * 数据查询
       **/
      const handleQuery = (params: any) => {
        loading.value = true;
        // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
        users.value = [];
        //集成axios发送查询请求
        axios.get("/mydelete/list", {
          //设置请求参数
          params: {
            page: params.page,
            size: params.size,
            userId: param.value.userId,
            wordId: param.value.wordId
          }
        }).then((response) => {
          loading.value = false;
          //获得返回值数据
          const data = response.data;
          //如果data.success为true，表示查询成功，即显示出文档信息
          if (data.success) {
            //显示出查询出来的记录
            users.value = data.content.list;

            // 重置分页按钮
            pagination.value.current = params.page;
            pagination.value.total = data.content.total;
            //如果data.success为false,表示查询失败，显示出错误信息
          } else {
            message.error(data.message);
          }
        });
      };

      /**
       * 表格点击页码时触发
       */
      const handleTableChange = (pagination: any) => {
        console.log("看看自带的分页参数都有啥：" + pagination);
        //分页查询
        handleQuery({
          page: pagination.current,
          size: pagination.pageSize
        });
      };

      onMounted(() => {
        handleQuery({
          page: 1,
          size: pagination.value.pageSize,
        });
      });

      //返回值
      return {
        param,
        users,
        pagination,
        columns,
        loading,
        handleTableChange,
        handleQuery,
      }
    }
  });
</script>

<style scoped>
  img {
    width: 50px;
    height: 50px;
  }
</style>
