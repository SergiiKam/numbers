<div align="justify">Test task for the position of an Android Developer<br>

You need to develop an app on Java/Kotlin for Android, “Interesting facts about numbers”. 
The application should allow the user to enter the number about which he wants to know an interesting fact, as well as - to randomly generate a number and get a fact about it. 
Application must contain 2 screens.

Main screen
It should be divided into two parts, the upper part is a field for entering a number, the button "Get fact" and the button "Get fact about random number", the lower part - display the history of user requests, each history element should show the number the user searched for and fact preview (everything that fits in one line), clicking on the element should open the 2nd screen.

2nd screen
Must display to the user the number and full text of the fact about the previously selected number. It should also be possible to return to the previous screen.

Task description
To get information about the number - use api http://numbersapi.com
For example, for the number "10" - the query http://numbersapi.com/10
To get the fact about the random number - http://numbersapi.com/random/math
For “http” queries don’t forget to add android:usesCleartextTraffic="true" to your Manifest file.

Main requirements
programming language: Java/Kotlin, IDE - Android Studio;
Queries to api must occur asynchronously (eg Coroutine, Rx);
Use Room to store data (fact search history);
The UI of the application is free, it is not a criterion for evaluating a test task;

Тестове завдання для кандидата на позицію Android Developer
 
Розробити додаток для Android, цікаві факти про числа, на Java/Kotlin. Додаток повинен дати можливість користувачу ввести число, про яке він хоче дізнатись цікавий факт, а також - випадково згенерувати число і отримати про нього факт. Додаток повинен містити 2 екрана.

Головний екран
Повинен бути розділений на дві частини, верхня частина - поле для введення числа, кнопка “Отримати факт” і кнопка “Отримати факт про випадкове число”, нижня частина - відображати історію запитів користувача, кожен елемент історії повинен показувати число, яке користувач раніше шукав і прев’ю факту( все, що поміщається в один рядок), по кліку на елемент повинен відкриватись 2й екран.

2й екран
Повинен відображати користувачу число і повний текст факту про вибране попередньо число. Також повинна бути можливість повернутись на попередній екран.

Опис завдання
Для отримання інформації про число - використовуємо api http://numbersapi.com. Наприклад, для числа “10” - запит http://numbersapi.com/10
Для отримання факту про випадкове число - http://numbersapi.com/random/math
Для “http” запитів не забудьте додати android:usesCleartextTraffic="true" в Manifest файл.

Основні вимоги
МП - Java/Kotlin, IDE - Android Studio;
Запити до api повинні відбуватись асинхронно(наприклад Coroutine, Rx);
Для зберігання даних(історії пошуку фактів) використовувати Room;
UI додатку - довільний, це не є критерієм оцінки тестового завдання;
</div>
