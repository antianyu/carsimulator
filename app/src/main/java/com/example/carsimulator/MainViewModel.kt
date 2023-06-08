package com.example.carsimulator

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 主界面 ViewModel
 *
 * @author Tianyu An
 */
class MainViewModel : ViewModel() {

    var data = mutableStateListOf<Section>()
    val navigation = MutableLiveData<Map<String, Int>>()

    init {
        data.add(Section(
            name = "悬挂",
            parts = listOf(
                Part("前悬架").addPart("前悬架横梁").addRubberGaskets("左前", "左后", "右前", "右后"),
                Part("后悬架").addPart("后悬架横梁").addRubberGaskets("左前", "左后", "右前", "右后"),
                Part("传动", "转向轴", "前驱动轴", "前驱动桥", "前防倾杆A", "前防倾杆B", "后驱动轴", "后防倾杆A", "后防倾杆B"),
            )
        ))
        data.add(Section(
            name = "左前",
            parts = listOf(
                Part("轮子", "轮胎", "轮毂"),
                Part("制动", "制动钳", "制动卡钳气缸", "刹车片", "刹车通风盘", "刹车盘"),
                Part("悬架外", "轮毂帽", "前驱动桥", "轮毂轴承", "前轮毂连轴", "前轮轴关节盖", "前转向节"),
                Part("悬架内", "内拉杆", "外拉杆", "防倾杆前端连杆A", "防倾杆前端连杆B", "前减震器", "前减震器顶盖", "前弹簧"),
                Part("底端摆臂").addPart("底端摆臂").addRubberGaskets("前衬套", "后衬套"),
                Part("下摆臂").addPart("下摆臂").addRubberGaskets("前衬套", "后衬套"),
                Part("上摆臂").addPart("上摆臂").addRubberGaskets("前衬套", "后衬套"),
            )
        ))
        data.add(Section(
            name = "右前",
            parts = listOf(
                Part("轮子", "轮胎", "轮毂"),
                Part("制动", "制动钳", "制动卡钳气缸", "刹车片", "刹车通风盘", "刹车盘"),
                Part("悬架外", "轮毂帽", "前驱动桥", "轮毂轴承", "前轮毂连轴", "前轮轴关节盖", "前转向节"),
                Part("悬架内", "内拉杆", "外拉杆", "防倾杆前端连杆A", "防倾杆前端连杆B", "前减震器", "前减震器顶盖", "前弹簧"),
                Part("底端摆臂").addPart("底端摆臂").addRubberGaskets("前衬套", "后衬套"),
                Part("下摆臂").addPart("下摆臂").addRubberGaskets("前衬套", "后衬套"),
                Part("上摆臂").addPart("上摆臂").addRubberGaskets("前衬套", "后衬套"),
            )
        ))
        data.add(Section(
            name = "左后",
            parts = listOf(
                Part("轮子", "轮胎", "轮毂"),
                Part("制动", "制动钳", "制动卡钳气缸", "刹车片", "刹车通风盘", "刹车盘", "制动鼓", "刹车蹄片", "制动轮缸"),
                Part("悬架外", "轮毂帽", "后驱动桥", "轮毂轴承", "后轮毂连轴", "轮毂关节", "后轮轴关节盖", "后轴关节", "小橡胶衬套"),
                Part("悬架内", "后减震器", "防倾杆后端连杆", "后摆臂", "后减震器顶盖", "后弹簧", "弹簧帽"),
                Part("后摆臂").addPart("后摆臂").addSmallRubberGaskets("外小衬套", "内小衬套"),
                Part("后上摆臂", "后上摆臂", "小橡胶衬套", "橡胶衬套"),
                Part("后悬挂臂", "后悬挂臂", "橡胶衬套"),
                Part("控制臂", listOf(
                    Part("叶片U型螺栓", "叶片U型螺栓(靠内)"),
                    Part("叶片U型螺栓", "叶片U型螺栓(靠外)"),
                    Part("叶片板"),
                    Part("实心轴控制臂"),
                    Part("橡胶衬套")
                )),
                Part("钢板弹簧").addPart("钢板弹簧").addSmallRubberGaskets("前衬套", "后衬套")
            )
        ))
        data.add(Section(
            name = "右后",
            parts = listOf(
                Part("轮子", "轮胎", "轮毂"),
                Part("制动", "制动钳", "制动卡钳气缸", "刹车片", "刹车通风盘", "刹车盘", "制动鼓", "刹车蹄片", "制动轮缸"),
                Part("悬架外", "轮毂帽", "后驱动桥", "轮毂轴承", "后轮毂连轴", "轮毂关节", "后轮轴关节盖", "后轴关节", "小橡胶衬套"),
                Part("悬架内", "后减震器", "防倾杆后端连杆", "后摆臂", "后减震器顶盖", "后弹簧", "弹簧帽"),
                Part("后摆臂").addPart("后摆臂").addSmallRubberGaskets("外小衬套", "内小衬套"),
                Part("后上摆臂", "后上摆臂", "小橡胶衬套", "橡胶衬套"),
                Part("后悬挂臂", "后悬挂臂", "橡胶衬套"),
                Part("控制臂", listOf(
                    Part("叶片U型螺栓", "叶片U型螺栓(靠内)"),
                    Part("叶片U型螺栓", "叶片U型螺栓(靠外)"),
                    Part("叶片板"),
                    Part("实心轴控制臂"),
                    Part("橡胶衬套")
                )),
                Part("钢板弹簧").addPart("钢板弹簧").addSmallRubberGaskets("前衬套", "后衬套")
            )
        ))
        data.add(Section(
            name = "引擎",
            parts = listOf(
                Part("冷却系统", "散热器风扇外壳", "散热器风扇外壳FAN", "散热器"),
                Part("通用", "电瓶", "滤油器", "空气过滤器", "机油滤清器", "ABS 模块", "ABS 泵", "伺服制动系统", "交流发电机"),
                Part("正时", "蛇形皮带", "蛇形皮带A", "蛇形皮带B", "水泵", "水泵皮带轮", "曲轴皮带轮", "转向助力泵", "皮带松紧调节器", "正时盖"),
                RepeatPart("惰辊A", "左1", "左2"),
                RepeatPart("惰辊B", "左1", "左2", "左3", "左4", "左5"),
                RepeatPart("正时皮带", "左", "右"),
                Part("引擎", "化油器", "油门", "进气歧管", "排气歧管盖", "排气歧管", "涡轮", "涡轮增压器", "油底壳", "曲轴", "点火线", "发动机缸体"),
                Part("变速", "启动装置", "变速箱", "分动箱", "离合器分离轴承", "离合器压板", "离合器片", "飞轮"),
                Part("油箱", "油箱", "油泵"),
                RepeatPart("发动机缸头", "左", "右"),
                RepeatPart("燃料喷嘴", "左", "右"),
                RepeatPart("发动机盖", "左", "右"),
                RepeatPart("点火线圈", "左1", "左2", "左3", "左4", "右1", "右2", "右3", "右4"),
                RepeatPart("火花塞", "左1", "左2", "左3", "左4", "右1", "右2", "右3", "右4"),
                RepeatPart("摇臂", "1", "2", "3", "4", "5", "6", "7", "8").apply { showName = "摇臂左" },
                RepeatPart("摇臂", "1", "2", "3", "4", "5", "6", "7", "8").apply { showName = "摇臂右" },
                RepeatPart("气门推杆", "1", "2", "3", "4", "5", "6", "7", "8").apply { showName = "推杆左" },
                RepeatPart("气门推杆", "1", "2", "3", "4", "5", "6", "7", "8").apply { showName = "推杆右" },
                RepeatPart("凸轮轴", "左上", "左下", "右上", "右下"),
                RepeatPart("凸轮齿轮", "左上", "左下", "右上", "右下"),
                RepeatPart("活塞环", "左1", "左2", "左3", "左4", "右1", "右2", "右3", "右4"),
                RepeatPart("连杆组", "左1", "左2", "左3", "左4", "右1", "右2", "右3", "右4"),
                RepeatPart("连杆盖", "左1", "左2", "左3", "左4", "右1", "右2", "右3", "右4"),
                RepeatPart("曲轴轴承盖", "左1", "左2", "左3", "左4", "右1", "右2", "右3", "右4"),
            )
        ))
        data.add(Section(
            name = "排气",
            parts = listOf(
                Part("排气", "前排气管", "三元催化器", "排气管", "中消声器", "后消声器", "左消音器", "右消音器", "消音器B"),
            )
        ))
        data.add(Section(
            name = "外观",
            parts = listOf(
                Part("正", "前保险杠", "前车牌", "引擎盖", "前挡风玻璃", "后挡风玻璃", "后备箱", "后备箱窗", "后车牌", "后保险杠"),
                Part("左", "前灯(左)", "尾灯(左)", "后备箱尾灯(左)", "左前翼子板", "左前门", "左后视镜", "左前门窗", "左后门", "左后门窗", "左窗A"),
                Part("右", "前灯(右)", "尾灯(右)", "后备箱尾灯(右)", "右前翼子板", "右前门", "右后视镜", "右前门窗", "右后门", "右后门窗", "右窗A"),
            )
        ))
        data.add(Section(
            name = "内饰",
            parts = listOf(
                Part("驾驶舱", "方向盘", "主驾", "副驾", "后排"),
            )
        ))
    }

    fun export() {
        val result = mutableListOf<String>()
        data.forEach { section ->
            section.parts.forEach {
                if (it.subParts.isNullOrEmpty()) {
                    if (it.damaged) {
                        result.add(it.name)
                    }
                } else {
                    it.subParts?.forEach { subPart ->
                        if (subPart.damaged) {
                            result.add(subPart.name)
                        }
                    }
                }
            }
        }
        navigation.value = result.groupBy { it }.map { it.key to it.value.size }.toMap()
    }

    fun clear() {
        data.forEach { section ->
            section.parts.forEach { part ->
                part.damaged = false
                part.subParts?.forEach {
                    it.damaged = false
                }
            }
        }
    }
}
