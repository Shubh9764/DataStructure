#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include<string.h>

int main()
{
    
    // Define an array of strings, each representing a stage of the hangman game
    char stages[7][7][30] = {
        {
            "   +---+ \n",
            "   |   | \n",
            "       | \n",
            "       | \n",
            "       | \n",
            "       | \n",
            "=========\n"
        },
        {
            "   +---+ \n",
            "   |   | \n",
            "   O   | \n",
            "       | \n",
            "       | \n",
            "       | \n",
            "=========\n"
        },
        {
            "   +---+ \n",
            "   |   | \n",
            "   O   | \n",
            "   |   | \n",
            "       | \n",
            "       | \n",
            "=========\n"
        },
        {
            "   +---+ \n",
            "   |   | \n",
            "   O   | \n",
            "  /|   | \n",
            "       | \n",
            "       | \n",
            "=========\n"
        },
        {
            "   +---+ \n",
            "   |   | \n",
            "   O   | \n",
            "  /|\\  | \n",
            "       | \n",
            "       | \n",
            "=========\n"
        },
        {
            "   +---+ \n",
            "   |   | \n",
            "   O   | \n",
            "  /|\\  | \n",
            "  /    | \n",
            "       | \n",
            "=========\n"
        },
        {
            "   +---+ \n",
            "   |   | \n",
            "   O   | \n",
            "  /|\\  | \n",
            "  / \\  | \n",
            "       | \n",
            "=========\n"
        }
    };

    
    
    
    
    char arr[10][10]={"shubham","ganesh","jyoti"};
    char str[10];
    int len,cnt=0,tmp=0,result,chance=7,original=7;
    
    char dash[10],guess;
    
    int lower = 0, upper = 2, count = 1,num;

    srand(time(0));

    
    for (int i = 0; i < count; i++) {
        num = (rand() % (upper - lower + 1)) + lower;
        
    }

strcpy(str,arr[num]);
printf("\nstr is:%s",str);
len=strlen(str);



printf("\nlength is:%d",len);

for(int k=0;k<len;k++)
{
    dash[k]='-';
}
printf("\ndash:%s",dash);

while(cnt==0)
{
    int correct=0;
    printf("\n\nChances u Have:%d",chance);
    printf("\nEnter Your Guess:");
    //gets(guess);
    scanf("\n%c",&guess);
    for(int k=0;k<len;k++)
    {
        if(str[k]==guess)
        {
            dash[k]=guess;
            correct=1;
        }
        
    }
    
    if(correct!=1)
    {
        //printf("\nOriginal:%d \nchance:%d",original,chance);
        printf("\nyou loose a life\n");
        
        // Display the stages of the hangman game
    int i=original-chance;
        for (int j = 0; j < 7; j++) {
            printf("%s", stages[i][j]);
        }
        printf("\n");
        chance-=1;
    }
    
    
    
    
    
    result=strcmp(dash,str);
    if(result==0)
    {
        printf("\nCongratulations,U guessed right!");
        tmp=1;
        cnt=1;
    }
    printf("\ndash:%s",dash);
    if(chance==0)
    {
        cnt=1;
    }
}
if(cnt==1&&tmp==0)
{
 printf("\nYou Loose"); 
}



    return 0;
}
