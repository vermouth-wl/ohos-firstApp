package com.vermouth.hellohermonyos.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.DependentLayout;
import ohos.agp.components.Text;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;

import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_CONTENT;
import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_PARENT;

public class SecondAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);

        // 声明布局
        DependentLayout dependentLayout = new DependentLayout(this);

        // 设置布局大小
        dependentLayout.setWidth(MATCH_PARENT);
        dependentLayout.setHeight(MATCH_PARENT);

        // 设置背景颜色
        ShapeElement shapeElement = new ShapeElement();
        shapeElement.setRgbColor(new RgbColor(0, 0, 0));
        dependentLayout.setBackground(shapeElement);

        // 创建文本组件并设置文本属性
        Text text = new Text(this);
        text.setText("谎言不会伤人，真相才是快刀");
        text.setWidth(MATCH_PARENT);
        text.setTextSize(35);
        text.setTextColor(Color.WHITE);

        // 设置文本布局并在文本组件中使用
        DependentLayout.LayoutConfig textConfig = new DependentLayout.LayoutConfig(MATCH_CONTENT, MATCH_CONTENT);
        textConfig.addRule(DependentLayout.LayoutConfig.CENTER_IN_PARENT);
        text.setLayoutConfig(textConfig);

        // 在布局管理器中添加文本组件
        dependentLayout.addComponent(text);
        super.setUIContent(dependentLayout);
    }

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
