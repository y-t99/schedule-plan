<template>
  <div class="y-history-wrap">
    <div class="grid-3">
      <div class="span-col-1 sa-warp flex-space-start">
        <div class="inline-flex-start sa-item-wrap">
          <div>您已经拥有日程记录：</div>
          <div>1128条</div>
        </div>
        <div class="inline-flex-start sa-item-wrap">
          <div>您前三的情绪是：</div>
          <div class="flex-start">
            <div class="flex-space-start">
              <div>专心的</div>
              <div>✍️</div>
            </div>
          </div>
          <div class="flex-start">
            <div class="flex-space-start emo-wrap">
              <div>热心的</div>
              <div>😀</div>
            </div>
          </div>
          <div class="flex-start">
            <div class="flex-space-start">
              <div>紧张的</div>
              <div>😣</div>
            </div>
          </div>
        </div>
        <div class="inline-flex-start sa-item-wrap">
          <div>在干饭里，您使用最多的标签是：</div>
          <div>水煮鱼</div>
        </div>
        <div class="inline-flex-start sa-item-wrap">
          <div>专业阅读里，您最长用的便签是：</div>
          <div>计算机网络</div>
        </div>
        <div class="inline-flex-start sa-item-wrap">
          <div>课外阅读里，您最长用的便签是：</div>
          <div>伊斯坦布尔假期</div>
        </div>
        <div class="inline-flex-start sa-item-wrap">
          <div>手机刷屏时，您最常用的APP是：</div>
          <div>微博</div>
        </div>
        <div class="inline-flex-start sa-item-wrap">
          <div>游戏休闲中，您最常玩的是：</div>
          <div>英雄联盟</div>
        </div>
      </div>
      <div class="span-col-1">
        <div class="charts-wrap flex-space-start">
          <div ref="get-bed" style="width: 400px; height: 300px"></div>
        </div>
      </div>
      <div class="span-col-1">
        <div class="charts-wrap flex-space-start">
          <div ref="go-to-bed" style="width: 400px; height: 300px"></div>
        </div>
      </div>
      <div class="span-col-1"></div>
      <div class="span-col-1">
        <div class="charts-title">记录类别统计</div>
        <div class="charts-wrap flex-space-start">
          <div ref="category-rate" style="width: 400px; height: 300px"></div>
        </div>
      </div>
      <div class="span-col-1">
        <div class="charts-wrap flex-space-start">
          <div ref="more" style="width: 400px; height: 300px"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import * as echarts from "echarts";
export default {
  methods: {},

  mounted() {
    let getBed = echarts.init(this.$refs["get-bed"]);
    getBed.setOption({
      title: {
        text: "起床时间",
        textStyle: {
          fontSize: 14,
          fontWeight: 500,
        },
      },
      tooltip: {},
      xAxis: {
        data: ["6点以前", "6-7点", "7-8点", "8点以后"],
      },
      yAxis: {},
      series: [
        {
          name: "天数",
          type: "line",
          data: [5, 10, 36, 30],
        },
      ],
    });
    let goToBed = echarts.init(this.$refs["go-to-bed"]);
    goToBed.setOption({
      title: {
        text: "睡觉时间",
        textStyle: {
          fontSize: 14,
          fontWeight: 500,
        },
      },
      tooltip: {},
      xAxis: {
        data: ["23点以前", "23点-23:30", "23:30-24点", "24点以后"],
      },
      yAxis: {},
      series: [
        {
          name: "天数",
          type: "line",
          data: [5, 30, 40, 25],
        },
      ],
    });
    let categoryRate = echarts.init(this.$refs["category-rate"]);
    categoryRate.setOption({
      tooltip: {
        trigger: "item",
      },
      legend: {
        top: "0",
        left: "center",
      },
      series: [
        {
          type: "pie",
          radius: ["40%", "70%"],
          avoidLabelOverlap: false,
          itemStyle: {
            borderRadius: 10,
            borderColor: "#fff",
            borderWidth: 2,
          },
          label: {
            show: false,
            position: "center",
          },
          emphasis: {
            label: {
              show: true,
              fontSize: "20",
              fontWeight: "bold",
            },
          },
          labelLine: {
            show: false,
          },
          data: [
            { value: 400, name: "生活健康投入" },
            { value: 100, name: "综合素养投入" },
            { value: 270, name: "社交娱乐投入" },
            { value: 342, name: "专业学习投入" },
            { value: 50, name: "实践能力投入" },
          ],
        },
      ],
    });
    let more = echarts.init(this.$refs["more"]);
    more.setOption({
graphic: {
    elements: [
      {
        type: 'text',
        left: 'center',
        top: 'center',
        style: {
          text: 'Schedule Plan',
          fontSize: 50,
          fontWeight: 'bold',
          lineDash: [0, 200],
          lineDashOffset: 0,
          fill: 'transparent',
          stroke: '#000',
          lineWidth: 1
        },
        keyframeAnimation: {
          duration: 3000,
          loop: false,
          keyframes: [
            {
              percent: 0.7,
              style: {
                fill: 'transparent',
                lineDashOffset: 200,
                lineDash: [200, 0]
              }
            },
            {
              // Stop for a while.
              percent: 0.8,
              style: {
                fill: 'transparent'
              }
            },
            {
              percent: 1,
              style: {
                fill: '#666'
              }
            }
          ]
        }
      }
    ]
  }
    });
  },
};
</script>

<style>
@import "./datasheet/css/grid.css";
@import "./datasheet/css/common.css";
.y-history-wrap {
  height: 700px;
}
.sa-warp {
  padding: 20px;
}
.sa-item-wrap {
  margin: 10px;
  color: #666;
  cursor: pointer;
}
.sa-item-wrap:hover {
  color: #409eff;
}
.emo-wrap {
  margin: 0px 5px;
}
.charts-wrap {
  padding-top: 30px;
}
.charts-title{
  font-size: 14px;
  color: #666;
  margin-bottom: -20px;
}
</style>
