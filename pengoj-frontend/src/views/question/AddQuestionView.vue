<template>
  <div id="addQuestionView">
    <h2>Add Question</h2>
    <a-form :model="form" label-align="left">
      <a-form-item field="title" label="Title">
        <a-input v-model="form.title" placeholder="please enter Title" />
      </a-form-item>
      <a-form-item field="tags" label="Tags">
        <a-input-tag
          v-model="form.tags"
          placeholder="please select a tag"
          allow-clear
        />
      </a-form-item>
      <a-form-item field="content" label="Question Content">
        <MdEditor :value="form.content" :handle-change="onContentChange" />
      </a-form-item>
      <a-form-item field="answer" label="Answer">
        <MdEditor :value="form.answer" :handle-change="onAnswerChange" />
      </a-form-item>
      <a-form-item
        label="Judge Config"
        :content-flex="false"
        :merge-props="false"
      >
        <a-space direction="vertical" style="min-width: 680px">
          <a-form-item
            field="judgeConfig.timeLimit"
            validate-trigger="input"
            :rules="[{ required: true, message: 'timeLimit is required' }]"
            label="Time Limit"
          >
            <a-input-number
              v-model="form.judgeConfig.timeLimit"
              placeholder="Please enter timeLimit"
              mode="button"
              min="0"
              size="large"
            />
          </a-form-item>
          <a-form-item
            field="judgeConfig.memoryLimit"
            validate-trigger="input"
            :rules="[{ required: true, message: 'memoryLimit is required' }]"
            label="Memory Limit"
          >
            <a-input-number
              v-model="form.judgeConfig.memoryLimit"
              placeholder="Please enter memoryLimit"
              mode="button"
              min="0"
              size="large"
            />
          </a-form-item>
          <a-form-item
            field="judgeConfig.stackLimit"
            validate-trigger="input"
            :rules="[{ required: true, message: 'stackLimit is required' }]"
            label="Stack Limit"
          >
            <a-input-number
              v-model="form.judgeConfig.stackLimit"
              placeholder="Please enter stackLimit"
              mode="button"
              min="0"
              size="large"
            />
          </a-form-item>
        </a-space>
      </a-form-item>
      <!--    <div>测试用例</div>-->
      <a-form-item
        label="Test Case Config"
        :content-flex="false"
        :merge-props="false"
      >
        <a-form-item
          v-for="(judgeCaseItem, index) of form.judgeCase"
          :key="index"
          no-style
        >
          <a-space direction="vertical" style="min-width: 680px">
            <a-form-item
              :field="`form.judgeCase[${index}].input`"
              :label="`Input Test Case-${index}`"
              :key="index"
            >
              <a-input
                v-model="judgeCaseItem.input"
                placeholder="Please enter Input Test Case"
              />
            </a-form-item>
            <a-form-item
              :field="`form.judgeCase[${index}].output`"
              :label="`Output Test Case-${index}`"
              :key="index"
            >
              <a-input
                v-model="judgeCaseItem.output"
                placeholder="Please enter Output Test Case"
              />
            </a-form-item>
            <a-button status="danger" @click="handleDelete(index)"
              >Delete
            </a-button>
          </a-space>
        </a-form-item>
        <div style="margin-top: 20px">
          <a-button @click="handleAdd" type="outline" status="success"
            >Add New Test Case
          </a-button>
        </div>
      </a-form-item>
      <a-form-item>
        <a-button type="primary" style="min-width: 200px" @click="doSubmit"
          >Submit
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from "vue";
import MdEditor from "@/components/MdEditor.vue";
import { QuestionControllerService } from "../../../generated";
import message from "@arco-design/web-vue/es/message";

const form = reactive({
  tags: ["栈", "简单"],
  title: "题目66",
  answer: "答案66",
  content: "内容66",
  judgeConfig: {
    memoryLimit: 1000,
    stackLimit: 1000,
    timeLimit: 1000,
  },
  judgeCase: [
    {
      input: "66",
      output: "66",
    },
  ],
});

const doSubmit = async () => {
  console.log(form);
  const res = await QuestionControllerService.addQuestionUsingPost(form);
  if (res.code === 0) {
    message.success("Add Successfully");
  } else {
    message.error("Add Filure, " + res.message);
  }
};

/**
 * 新增测试用例
 */
const handleAdd = () => {
  form.judgeCase.push({
    input: "",
    output: "",
  });
};

/**
 * 删除判题用例
 */
const handleDelete = (index: number) => {
  form.judgeCase.splice(index, 1);
};

const onContentChange = (value: string) => {
  form.content = value;
};

const onAnswerChange = (value: string) => {
  form.answer = value;
};
</script>

<style scoped>
#addQuestionView {
}
</style>
