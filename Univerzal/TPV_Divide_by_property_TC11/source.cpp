#define  _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <tccore/custom.h>
#include <epm/epm.h>
#include <ict/ict_userservice.h>
#include <tc/tc.h>
#include <user_exits/user_exits.h>
#include <tc/tc.h>
#include <tccore/item.h>
#include <tccore/aom_prop.h>
#include <ps/ps.h>
#include <bom/bom.h>

#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))
int next_way;

extern "C" DLLAPI int TPV_Divide_by_property_TC11_register_callbacks();
extern "C" DLLAPI int TPV_Divide_by_property_TC11_init_module(int *decision, va_list args);
int TPV_Divide_by_property(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);
int ListBomLine(tag_t BomLine, int Level, int decision, char* ItemId);
extern "C" DLLAPI int TPV_Divide_by_property_TC11_register_callbacks()
{
    printf("Registruji TPV_Divide_by_property_TC11.dll\n");
    CUSTOM_register_exit("TPV_Divide_by_property_TC11", "USER_init_module", TPV_Divide_by_property_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Divide_by_property_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Divide_by_property", "", TPV_Divide_by_property);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_Divide_by_property");

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}


void AddToRef(tag_t RootTask,tag_t *Object,int num,tag_t puvodni)
{
	for (int i =0;i<num;i++)
	{
		const int AttachmentTypes[1] = {EPM_reference_attachment};
		if(puvodni!=Object[i])
		{
		printf("Pridej do reference rt %d num %d obj %d AT %d \n",RootTask, num, &Object[i], AttachmentTypes[0]);
		EPM_add_attachments(RootTask, 1, &Object[i], AttachmentTypes);
		printf("Pridano \n");
		}else printf("shoda s puvodni \n ");
	}
	next_way=1;
}

int TPV_Divide_by_property(EPM_action_message_t msg)
{
	char *Argument=nullptr;
	char*Flag = nullptr;
	char*Value = nullptr;
	char Vlastnost [20]; 
	char Vlastnost2 [20];
	char podminka [5];
	char podminka2 [5];
	char vysledek [20];
	char vysledek2 [20]="NULL";
	char hodnota [20];
	char hodnota2 [20];
	char obj_type[30]="NULL";
	logical and=false; 
	logical or=false; 
	next_way=ITK_ok;

	int ArgumentCount=TC_number_of_arguments(msg.arguments);

	while (ArgumentCount --> 0)
	{
		Argument = TC_next_argument( msg.arguments );
		ITK_ask_argument_named_value( ( const char* ) Argument, &Flag, &Value );
		if( strcmp ( "vlastnost", Flag ) == 0 && Value != nullptr)
		{
// …
			printf("value property %s \n",Value);
			strcpy(Vlastnost,Value);
		}
		if( strcmp ( "hodnota", Flag ) == 0 && Value != nullptr)
		{
// …
			printf("value hodnota %s \n",Value);
			strcpy(hodnota,Value);
		}
		if( strcmp ( "podminka", Flag ) == 0 && Value != nullptr)
		{
// …
			printf("value hodnota %s \n",Value);
			strcpy(podminka,Value);
		}
		if( strcmp ( "vysledek", Flag ) == 0 && Value != nullptr)
		{// …
			printf("value hodnota %s \n",Value);
			strcpy(vysledek,Value);
		}
		if( strcmp ( "operator", Flag ) == 0 && Value != nullptr)
		{// …
			printf("value hodnota %s \n",Value);
			and=true;
		}
		if( strcmp ( "vlastnost2", Flag ) == 0 && Value != nullptr)
		{
// …
			printf("value property %s \n",Value);
			strcpy(Vlastnost2,Value);
		}
		if( strcmp ( "hodnota2", Flag ) == 0 && Value != nullptr)
		{
// …
			printf("value hodnota %s \n",Value);
			strcpy(hodnota2,Value);
		}
		if( strcmp ( "podminka2", Flag ) == 0 && Value != nullptr)
		{
// …
			printf("value hodnota %s \n",Value);
			strcpy(podminka2,Value);
		}
		if( strcmp ( "vysledek2", Flag ) == 0 && Value != nullptr)
		{// …
			printf("value hodnota %s \n",Value);
			strcpy(vysledek2,Value);
		}
		if( strcmp ( "object_type", Flag ) == 0 && Value != nullptr)
		{// …
			printf("value hodnota %s \n",Value);
			strcpy(obj_type,Value);
		}
	}
		  tag_t
			RootTask=NULLTAG;
		int TargetsCount = 0;
		tag_t *Targets = NULLTAG;
		tag_t TargetClassTag = NULLTAG;
		tag_t RevisionClassTag = NULLTAG;


	//int BomsCount = 0;
        //tag_t *Boms = NULLTAG;

		EPM_ask_root_task ( msg.task, &RootTask );
		EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
		printf("count %d \n",TargetsCount);
		for( int i = 0; i < TargetsCount; i ++ )
		{
	/*		POM_class_of_instance(Targets[i], &TargetClassTag);
			logical IsRevision = false;
			POM_is_descendant(RevisionClassTag, TargetClassTag, &IsRevision);

			if(IsRevision == false) continue;*/
			printf(" vlastnost1=%s vlastnost2=%s \n",Vlastnost,Vlastnost2); 
			logical prvni=false;
			logical druhy=false;
			char* tmp;
			char* tmp2;
			char* this_obj_type;
			
			AOM_ask_value_string(Targets[i],"object_type",&this_obj_type);
			printf("\n vysledek %s = %s vysledek2 %s = %s \n",vysledek,tmp,vysledek2,tmp2);

			if(strcmp(obj_type,this_obj_type)==0 || strcmp(obj_type,"NULL")==0)
				{
					AOM_ask_value_string(Targets[i],Vlastnost,&tmp);
					if(strcmp(Vlastnost2,"NULL")!=0)
					AOM_ask_value_string(Targets[i],Vlastnost2,&tmp2);
					
					if (strcmp(vysledek,"NULL")==0)
					{	printf ("delka %d \n",strlen(tmp));
						if(	strlen(tmp)==0)
						{
							prvni==true;
							printf(" prvni true \n");
						}
					}
					else 
					{	printf("\n %s = %s \n",tmp,vysledek);
						if(strcmp(tmp,vysledek)==0)
						{
							prvni=true;
							printf("prvni %d \n",prvni);
						}
					}

					if (strcmp(vysledek2,"NULL")==0)
					{	printf ("delka %d \n",strlen(tmp2));
						if(	strlen(tmp2)==0)
						{
							druhy=true;
							printf("druhy true \n");
						}
					}
					else 
					{	printf("\n %s = %s \n",tmp2,vysledek2);
						if(strcmp(tmp2,vysledek2)==0)
						{
							druhy=true;
							printf("druhy %d \n",druhy);
						}
					}

					printf("%s = %s \n",Vlastnost,tmp);
					if(strcmp(podminka,"je")==0 && strcmp(podminka2,"je")==0)
					{
						printf("line %d \n",__LINE__);
						if(and)
							if (prvni && druhy)
							AddToRef(RootTask,&Targets[i],1,NULLTAG);
						else if(or)
							if (prvni || druhy)
							AddToRef(RootTask,&Targets[i],1,NULLTAG);
				

					}else if (strcmp(podminka,"neni")==0 && strcmp(podminka2,"je")==0)
					{
						printf("line %d \n",__LINE__);
						if(and)
						{
							printf("line %d and %d %d \n",__LINE__,prvni,druhy);
							if (prvni==false && druhy==true)
							AddToRef(RootTask,&Targets[i],1,NULLTAG);
						}else if(or){
							printf("line %d or\n",__LINE__);
							if (prvni==false || druhy==true)
							AddToRef(RootTask,&Targets[i],1,NULLTAG);
						}
					}
					else if (strcmp(podminka,"neni")==0 && strcmp(podminka2,"neni")==0)
					{
						printf("line %d 218\n",__LINE__);
						if(and)
							if (!prvni && !druhy)
							AddToRef(RootTask,&Targets[i],1,NULLTAG);
						else if(or)
							if (!prvni || !druhy)
							AddToRef(RootTask,&Targets[i],1,NULLTAG);
				
					}
					else if (strcmp(podminka,"je")==0 && strcmp(podminka2,"neni")==0)
					{
						printf("line %d \n",__LINE__);
						if(and)
						{
							printf("and %d %d \n",prvni,druhy);
							if (prvni && !druhy)
							AddToRef(RootTask,&Targets[i],1,NULLTAG);
						}
						else if(or)
						{
							if (prvni || !druhy)
							AddToRef(RootTask,&Targets[i],1,NULLTAG);
						}
					}
					else if (strcmp(podminka,"je")==0)
					{
						printf("line %d \n",__LINE__);
					 if (prvni)
							AddToRef(RootTask,&Targets[i],1,NULLTAG);
					}
					else if (strcmp(podminka,"neni")==0)
					{
						printf("line %d \n",__LINE__);
					 if (!prvni)
							AddToRef(RootTask,&Targets[i],1,NULLTAG);
					}
			}
		}


       // system("C:\\SPLM\\TC\\bin\\VyplnND.exe");

    return next_way;
}