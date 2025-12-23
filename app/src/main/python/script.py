import requests
from rich import print

def start_logic(token, chat_id):
    # هذا هو الكود الذي أرسلته أنت معدلاً ليعمل كمهمة خلفية
    msg = " ┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉\n╮❲ تم تشغيل الاداة بنجاح ❳\n┤❲ سيتم ارسال الصيد الي بوتك ❳\n┤❲ المبرمج ❳ > @W4_M4  تم فك وردتي ❳\n┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉"
    url = f"https://api.telegram.org/bot{token}/sendMessage?chat_id={chat_id}&text={msg}"
    requests.get(url)
    
    # هنا تضع بقية منطق الـ Cracker الخاص بك
    return "بدأ الصيد بنجاح، راقب التلجرام!"
