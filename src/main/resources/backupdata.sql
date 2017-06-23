INSERT INTO public.system_code_type (id, code_type, description) VALUES (nextval('system_code_type_seq'), 'COST_CATEGORY',  'COST_CATEGORY');

INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'GOVERNMENTAL', false, 1, 1);
INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'PAYROLL', false, 1, 2);
INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'RENTAL', false, 1, 3);
INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'UTILITIES', false, 1, 4);
INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'OTHER_COST_CATEGORIES', false, 1, 5);

INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('رسوم حكومية', 'عوائد، ضرائب، الخ.', 1, 1);
INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('موظفين', 'مرتبات، بدلات، حوافز للموظفين', 2, 1);
INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('ايجارات', 'ايجار محل أو مخزن', 3, 1);
INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('خدمات', 'كهرباء، ماء، غاز، الخ.', 4, 1);
INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('منصرفات أخرى', 'منصرفات أخرى', 5, 1);

----

INSERT INTO public.system_code_type (id, code_type, description) VALUES (nextval('system_code_type_seq'), 'JOB_TYPE',  'JOB_TYPE');

INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'COOK', false, 2, 1);
INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'WAITER', false, 2, 2);
INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'CASHIER', false, 2, 3);
INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'ACCOUNTANT', false, 2, 4);
INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'SUPERVISOR', false, 2, 5);
INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'CLEANER', false, 2, 6);
INSERT INTO public.system_code (id, code, user_defined, system_code_type_id, list_order) VALUES (nextval('system_code_seq'), 'OTHER_JOB_TYPES', false, 2, 7);

INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('طباخ', 'طباخ', 6, 1);
INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('جرسون', 'جرسون', 7, 1);
INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('كاشير', 'كاشير', 8, 1);
INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('محاسب', 'محاسب', 9, 1);
INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('مشرف', 'مشرف', 10, 1);
INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('عامل نظافة', 'عامل نظافة', 11, 1);
INSERT INTO public.system_code_trans (lang_code, lang_description, system_code_id, language_id) VALUES ('أخرى', 'أخرى', 12, 1);

----
