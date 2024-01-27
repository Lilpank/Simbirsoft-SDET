***<p style="text-align: center;">Practice Simbirsoft-SDET  проект UI-автотестирование</p>***
-

[Текст задачи](https://github.com/Lilpank/Simbisoft-SDET/blob/master/simbirsoft-resources/%D0%A2%D0%B5%D1%81%D1%82%D0%BE%D0%B2%D0%BE%D0%B5%20%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BE%D1%82%20SimbirSoft%20%D0%BF%D0%BE%20SDET_%D1%81%20%D0%B4%D0%B5%D0%BA%D0%B0%D0%B1%D1%80%D1%8F%202023.pdf)

[Полезные материалы от Simbirsoft](https://github.com/Lilpank/Simbisoft-SDET/blob/master/simbirsoft-resources/SDET-Guide.pdf)

В проекте используется Java-17, TestNG, Allure, Selenium с паттерном Page Object Model.

Команда для запуска тестов через maven:
```shell
mvn clean verify
```
В директории /target выполнить последовательно команду фреймворка Allure для визуализации отчета:
```shell
%ALLURE_HOME%\bin\allure.bat generate
%ALLURE_HOME%\bin\allure.bat open
```
<p style="text-align: center;">Тестируемая форма</p>

![img.png](pictures%20for%20readme.md%2Fimg.png)


В ходе данной работы был написан функционал для тестирования всей странички.

<p style="text-align: center;">Результат работы тестов:</p>

![img_1.png](pictures%20for%20readme.md%2Fimg_1.png)
