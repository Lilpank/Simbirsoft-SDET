***<p style="text-align: center;">Practice Simbirsoft-SDET  проект UI-автотестирование</p>***
-

[Текст задачи](https://github.com/Lilpank/Simbisoft-SDET/tree/master/reporting%20pictures)

[Полезные материалы](https://github.com/Lilpank/Simbisoft-SDET/tree/master/reporting%20pictures)

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

![img.png](reporting%20pictures%2Fimg.png)


В ходе данной работы был написан функционал для тестирования всей странички.

<p style="text-align: center;">Результат работы тестов:</p>

![img_1.png](reporting%20pictures%2Fimg_1.png)

